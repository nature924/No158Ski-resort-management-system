
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 赛道预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saidaoYuyue")
public class SaidaoYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(SaidaoYuyueController.class);

    private static final String TABLE_NAME = "saidaoYuyue";

    @Autowired
    private SaidaoYuyueService saidaoYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JiaolianService jiaolianService;//教练
    @Autowired
    private JiaolianYuyueService jiaolianYuyueService;//教练预约
    @Autowired
    private LiuyanService liuyanService;//留言板
    @Autowired
    private QijuService qijuService;//滑雪器具
    @Autowired
    private QijuCollectionService qijuCollectionService;//器具收藏
    @Autowired
    private QijuCommentbackService qijuCommentbackService;//器具评价
    @Autowired
    private QijuOrderService qijuOrderService;//器具订单
    @Autowired
    private SaidaoService saidaoService;//赛道
    @Autowired
    private SaidaoCollectionService saidaoCollectionService;//赛道收藏
    @Autowired
    private SaidaoLiuyanService saidaoLiuyanService;//赛道留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教练".equals(role))
            params.put("jiaolianId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = saidaoYuyueService.queryPage(params);

        //字典表数据转换
        List<SaidaoYuyueView> list =(List<SaidaoYuyueView>)page.getList();
        for(SaidaoYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaidaoYuyueEntity saidaoYuyue = saidaoYuyueService.selectById(id);
        if(saidaoYuyue !=null){
            //entity转view
            SaidaoYuyueView view = new SaidaoYuyueView();
            BeanUtils.copyProperties( saidaoYuyue , view );//把实体数据重构到view中
            //级联表 赛道
            //级联表
            SaidaoEntity saidao = saidaoService.selectById(saidaoYuyue.getSaidaoId());
            if(saidao != null){
            BeanUtils.copyProperties( saidao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSaidaoId(saidao.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(saidaoYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SaidaoYuyueEntity saidaoYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saidaoYuyue:{}",this.getClass().getName(),saidaoYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            saidaoYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SaidaoYuyueEntity> queryWrapper = new EntityWrapper<SaidaoYuyueEntity>()
            .eq("saidao_id", saidaoYuyue.getSaidaoId())
            .eq("yonghu_id", saidaoYuyue.getYonghuId())
            .eq("saidao_yuyue_time", new SimpleDateFormat("yyyy-MM-dd").format(saidaoYuyue.getSaidaoYuyueTime()))
            .in("saidao_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaidaoYuyueEntity saidaoYuyueEntity = saidaoYuyueService.selectOne(queryWrapper);
        if(saidaoYuyueEntity==null){
            saidaoYuyue.setInsertTime(new Date());
            saidaoYuyue.setSaidaoYuyueYesnoTypes(1);
            saidaoYuyue.setCreateTime(new Date());
            saidaoYuyueService.insert(saidaoYuyue);
            return R.ok();
        }else {
            if(saidaoYuyueEntity.getSaidaoYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(saidaoYuyueEntity.getSaidaoYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaidaoYuyueEntity saidaoYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,saidaoYuyue:{}",this.getClass().getName(),saidaoYuyue.toString());
        SaidaoYuyueEntity oldSaidaoYuyueEntity = saidaoYuyueService.selectById(saidaoYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            saidaoYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(saidaoYuyue.getSaidaoYuyueText()) || "null".equals(saidaoYuyue.getSaidaoYuyueText())){
                saidaoYuyue.setSaidaoYuyueText(null);
        }
        if("".equals(saidaoYuyue.getSaidaoYuyueYesnoText()) || "null".equals(saidaoYuyue.getSaidaoYuyueYesnoText())){
                saidaoYuyue.setSaidaoYuyueYesnoText(null);
        }

            saidaoYuyueService.updateById(saidaoYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody SaidaoYuyueEntity saidaoYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,saidaoYuyueEntity:{}",this.getClass().getName(),saidaoYuyueEntity.toString());

        SaidaoYuyueEntity oldSaidaoYuyue = saidaoYuyueService.selectById(saidaoYuyueEntity.getId());//查询原先数据

        if(saidaoYuyueEntity.getSaidaoYuyueYesnoTypes() == 2){//通过

            SaidaoYuyueEntity saidaoYuyueEntity1 = saidaoYuyueService.selectOne(new EntityWrapper<SaidaoYuyueEntity>()
                    .eq("saidao_id", oldSaidaoYuyue.getSaidaoId())
                    .eq("saidao_yuyue_time", new SimpleDateFormat("yyyy-MM-dd").format(oldSaidaoYuyue.getSaidaoYuyueTime()))
                    .eq("saidao_yuyue_yesno_types", 2)
            );
            if(saidaoYuyueEntity1 != null)
                return R.error("该赛道该天已经被预约,不能通过此次预约了");
        }else if(saidaoYuyueEntity.getSaidaoYuyueYesnoTypes() == 3){//拒绝
            YonghuEntity yonghuEntity = yonghuService.selectById(oldSaidaoYuyue.getYonghuId());
            if(yonghuEntity==null){
                return R.error("查不到用户");
            }
            SaidaoEntity saidaoEntity = saidaoService.selectById(oldSaidaoYuyue.getSaidaoId());
            if(saidaoEntity==null){
                return R.error("查不到赛道");
            }

            double balance = yonghuEntity.getNewMoney() + saidaoEntity.getSaidaoNewMoney();
            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);
        }
        saidaoYuyueEntity.setSaidaoYuyueShenheTime(new Date());//审核时间
        saidaoYuyueService.updateById(saidaoYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SaidaoYuyueEntity> oldSaidaoYuyueList =saidaoYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        saidaoYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<SaidaoYuyueEntity> saidaoYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SaidaoYuyueEntity saidaoYuyueEntity = new SaidaoYuyueEntity();
//                            saidaoYuyueEntity.setSaidaoYuyueUuidNumber(data.get(0));                    //申请编号 要改的
//                            saidaoYuyueEntity.setSaidaoId(Integer.valueOf(data.get(0)));   //赛道 要改的
//                            saidaoYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            saidaoYuyueEntity.setSaidaoYuyueText(data.get(0));                    //申请缘由 要改的
//                            saidaoYuyueEntity.setSaidaoYuyueTime(sdf.parse(data.get(0)));          //预约日期 要改的
//                            saidaoYuyueEntity.setInsertTime(date);//时间
//                            saidaoYuyueEntity.setSaidaoYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            saidaoYuyueEntity.setSaidaoYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            saidaoYuyueEntity.setSaidaoYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            saidaoYuyueEntity.setCreateTime(date);//时间
                            saidaoYuyueList.add(saidaoYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("saidaoYuyueUuidNumber")){
                                    List<String> saidaoYuyueUuidNumber = seachFields.get("saidaoYuyueUuidNumber");
                                    saidaoYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> saidaoYuyueUuidNumber = new ArrayList<>();
                                    saidaoYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("saidaoYuyueUuidNumber",saidaoYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<SaidaoYuyueEntity> saidaoYuyueEntities_saidaoYuyueUuidNumber = saidaoYuyueService.selectList(new EntityWrapper<SaidaoYuyueEntity>().in("saidao_yuyue_uuid_number", seachFields.get("saidaoYuyueUuidNumber")));
                        if(saidaoYuyueEntities_saidaoYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SaidaoYuyueEntity s:saidaoYuyueEntities_saidaoYuyueUuidNumber){
                                repeatFields.add(s.getSaidaoYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        saidaoYuyueService.insertBatch(saidaoYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = saidaoYuyueService.queryPage(params);

        //字典表数据转换
        List<SaidaoYuyueView> list =(List<SaidaoYuyueView>)page.getList();
        for(SaidaoYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaidaoYuyueEntity saidaoYuyue = saidaoYuyueService.selectById(id);
            if(saidaoYuyue !=null){


                //entity转view
                SaidaoYuyueView view = new SaidaoYuyueView();
                BeanUtils.copyProperties( saidaoYuyue , view );//把实体数据重构到view中

                //级联表
                    SaidaoEntity saidao = saidaoService.selectById(saidaoYuyue.getSaidaoId());
                if(saidao != null){
                    BeanUtils.copyProperties( saidao , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaidaoId(saidao.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(saidaoYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody SaidaoYuyueEntity saidaoYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,saidaoYuyue:{}",this.getClass().getName(),saidaoYuyue.toString());
        Wrapper<SaidaoYuyueEntity> queryWrapper = new EntityWrapper<SaidaoYuyueEntity>()
            .eq("saidao_id", saidaoYuyue.getSaidaoId())
            .eq("yonghu_id", saidaoYuyue.getYonghuId())
            .in("saidao_yuyue_yesno_types", new Integer[]{1})
//            .notIn("saidao_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaidaoYuyueEntity saidaoYuyueEntity = saidaoYuyueService.selectOne(queryWrapper);
        if(saidaoYuyueEntity==null){


            YonghuEntity yonghuEntity = yonghuService.selectById(saidaoYuyue.getYonghuId());
            if(yonghuEntity==null){
                return R.error("查不到用户");
            }
            SaidaoEntity saidaoEntity = saidaoService.selectById(saidaoYuyue.getSaidaoId());
            if(saidaoEntity==null){
                return R.error("查不到赛道");
            }

            double balance = yonghuEntity.getNewMoney() - saidaoEntity.getSaidaoNewMoney();
            if(balance<0)
                return R.error("账户余额不够支付,请充值后再预约");
            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);

            saidaoYuyue.setInsertTime(new Date());
            saidaoYuyue.setSaidaoYuyueYesnoTypes(1);
            saidaoYuyue.setCreateTime(new Date());
        saidaoYuyueService.insert(saidaoYuyue);

            return R.ok();
        }else {
            if(saidaoYuyueEntity.getSaidaoYuyueYesnoTypes()==1)
                return R.error(511,"有该赛道的预约,请等待审核后再预约");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

