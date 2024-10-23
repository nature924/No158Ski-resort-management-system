
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
 * 滑雪器具
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qiju")
public class QijuController {
    private static final Logger logger = LoggerFactory.getLogger(QijuController.class);

    private static final String TABLE_NAME = "qiju";

    @Autowired
    private QijuService qijuService;


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
    private SaidaoYuyueService saidaoYuyueService;//赛道预约
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
        params.put("qijuDeleteStart",1);params.put("qijuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = qijuService.queryPage(params);

        //字典表数据转换
        List<QijuView> list =(List<QijuView>)page.getList();
        for(QijuView c:list){
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
        QijuEntity qiju = qijuService.selectById(id);
        if(qiju !=null){
            //entity转view
            QijuView view = new QijuView();
            BeanUtils.copyProperties( qiju , view );//把实体数据重构到view中
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
    public R save(@RequestBody QijuEntity qiju, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qiju:{}",this.getClass().getName(),qiju.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<QijuEntity> queryWrapper = new EntityWrapper<QijuEntity>()
            .eq("qiju_name", qiju.getQijuName())
            .eq("qiju_types", qiju.getQijuTypes())
            .eq("qiju_kucun_number", qiju.getQijuKucunNumber())
            .eq("shangxia_types", qiju.getShangxiaTypes())
            .eq("qiju_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QijuEntity qijuEntity = qijuService.selectOne(queryWrapper);
        if(qijuEntity==null){
            qiju.setQijuClicknum(1);
            qiju.setShangxiaTypes(1);
            qiju.setQijuDelete(1);
            qiju.setInsertTime(new Date());
            qiju.setCreateTime(new Date());
            qijuService.insert(qiju);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QijuEntity qiju, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qiju:{}",this.getClass().getName(),qiju.toString());
        QijuEntity oldQijuEntity = qijuService.selectById(qiju.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(qiju.getQijuPhoto()) || "null".equals(qiju.getQijuPhoto())){
                qiju.setQijuPhoto(null);
        }
        if("".equals(qiju.getQijuContent()) || "null".equals(qiju.getQijuContent())){
                qiju.setQijuContent(null);
        }

            qijuService.updateById(qiju);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QijuEntity> oldQijuList =qijuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<QijuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            QijuEntity qijuEntity = new QijuEntity();
            qijuEntity.setId(id);
            qijuEntity.setQijuDelete(2);
            list.add(qijuEntity);
        }
        if(list != null && list.size() >0){
            qijuService.updateBatchById(list);
        }

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
            List<QijuEntity> qijuList = new ArrayList<>();//上传的东西
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
                            QijuEntity qijuEntity = new QijuEntity();
//                            qijuEntity.setQijuName(data.get(0));                    //器具名称 要改的
//                            qijuEntity.setQijuUuidNumber(data.get(0));                    //器具编号 要改的
//                            qijuEntity.setQijuPhoto("");//详情和图片
//                            qijuEntity.setQijuTypes(Integer.valueOf(data.get(0)));   //器具类型 要改的
//                            qijuEntity.setQijuKucunNumber(Integer.valueOf(data.get(0)));   //器具数量 要改的
//                            qijuEntity.setQijuOldMoney(data.get(0));                    //器具原价 要改的
//                            qijuEntity.setQijuNewMoney(data.get(0));                    //租赁价格/天 要改的
//                            qijuEntity.setQijuClicknum(Integer.valueOf(data.get(0)));   //器具热度 要改的
//                            qijuEntity.setQijuContent("");//详情和图片
//                            qijuEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            qijuEntity.setQijuDelete(1);//逻辑删除字段
//                            qijuEntity.setInsertTime(date);//时间
//                            qijuEntity.setCreateTime(date);//时间
                            qijuList.add(qijuEntity);


                            //把要查询是否重复的字段放入map中
                                //器具编号
                                if(seachFields.containsKey("qijuUuidNumber")){
                                    List<String> qijuUuidNumber = seachFields.get("qijuUuidNumber");
                                    qijuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qijuUuidNumber = new ArrayList<>();
                                    qijuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qijuUuidNumber",qijuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //器具编号
                        List<QijuEntity> qijuEntities_qijuUuidNumber = qijuService.selectList(new EntityWrapper<QijuEntity>().in("qiju_uuid_number", seachFields.get("qijuUuidNumber")).eq("qiju_delete", 1));
                        if(qijuEntities_qijuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QijuEntity s:qijuEntities_qijuUuidNumber){
                                repeatFields.add(s.getQijuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [器具编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qijuService.insertBatch(qijuList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<QijuView> returnQijuViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("qijuYesnoTypes",2);
        PageUtils pageUtils = qijuOrderService.queryPage(params1);
        List<QijuOrderView> orderViewsList =(List<QijuOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(QijuOrderView orderView:orderViewsList){
            Integer qijuTypes = orderView.getQijuTypes();
            if(typeMap.containsKey(qijuTypes)){
                typeMap.put(qijuTypes,typeMap.get(qijuTypes)+1);
            }else{
                typeMap.put(qijuTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("qijuTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("qijuYesnoTypes",2);
            PageUtils pageUtils1 = qijuService.queryPage(params2);
            List<QijuView> qijuViewList =(List<QijuView>)pageUtils1.getList();
            returnQijuViewList.addAll(qijuViewList);
            if(returnQijuViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("qijuYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = qijuService.queryPage(params);
        if(returnQijuViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnQijuViewList.size();//要添加的数量
            List<QijuView> qijuViewList =(List<QijuView>)page.getList();
            for(QijuView qijuView:qijuViewList){
                Boolean addFlag = true;
                for(QijuView returnQijuView:returnQijuViewList){
                    if(returnQijuView.getId().intValue() ==qijuView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnQijuViewList.add(qijuView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnQijuViewList = returnQijuViewList.subList(0, limit);
        }

        for(QijuView c:returnQijuViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnQijuViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = qijuService.queryPage(params);

        //字典表数据转换
        List<QijuView> list =(List<QijuView>)page.getList();
        for(QijuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QijuEntity qiju = qijuService.selectById(id);
            if(qiju !=null){

                //点击数量加1
                qiju.setQijuClicknum(qiju.getQijuClicknum()+1);
                qijuService.updateById(qiju);

                //entity转view
                QijuView view = new QijuView();
                BeanUtils.copyProperties( qiju , view );//把实体数据重构到view中

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
    public R add(@RequestBody QijuEntity qiju, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qiju:{}",this.getClass().getName(),qiju.toString());
        Wrapper<QijuEntity> queryWrapper = new EntityWrapper<QijuEntity>()
            .eq("qiju_name", qiju.getQijuName())
            .eq("qiju_uuid_number", qiju.getQijuUuidNumber())
            .eq("qiju_types", qiju.getQijuTypes())
            .eq("qiju_kucun_number", qiju.getQijuKucunNumber())
            .eq("qiju_clicknum", qiju.getQijuClicknum())
            .eq("shangxia_types", qiju.getShangxiaTypes())
            .eq("qiju_delete", qiju.getQijuDelete())
//            .notIn("qiju_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        QijuEntity qijuEntity = qijuService.selectOne(queryWrapper);
        if(qijuEntity==null){
            qiju.setQijuClicknum(1);
            qiju.setQijuDelete(1);
            qiju.setInsertTime(new Date());
            qiju.setCreateTime(new Date());
        qijuService.insert(qiju);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

