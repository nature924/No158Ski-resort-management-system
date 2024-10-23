
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
 * 器具订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/qijuOrder")
public class QijuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(QijuOrderController.class);

    private static final String TABLE_NAME = "qijuOrder";

    @Autowired
    private QijuOrderService qijuOrderService;


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
        CommonUtil.checkMap(params);
        PageUtils page = qijuOrderService.queryPage(params);

        //字典表数据转换
        List<QijuOrderView> list =(List<QijuOrderView>)page.getList();
        for(QijuOrderView c:list){
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
        QijuOrderEntity qijuOrder = qijuOrderService.selectById(id);
        if(qijuOrder !=null){
            //entity转view
            QijuOrderView view = new QijuOrderView();
            BeanUtils.copyProperties( qijuOrder , view );//把实体数据重构到view中
            //级联表 滑雪器具
            //级联表
            QijuEntity qiju = qijuService.selectById(qijuOrder.getQijuId());
            if(qiju != null){
            BeanUtils.copyProperties( qiju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setQijuId(qiju.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(qijuOrder.getYonghuId());
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
    public R save(@RequestBody QijuOrderEntity qijuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,qijuOrder:{}",this.getClass().getName(),qijuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            qijuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        qijuOrder.setCreateTime(new Date());
        qijuOrder.setInsertTime(new Date());
        qijuOrderService.insert(qijuOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody QijuOrderEntity qijuOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,qijuOrder:{}",this.getClass().getName(),qijuOrder.toString());
        QijuOrderEntity oldQijuOrderEntity = qijuOrderService.selectById(qijuOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            qijuOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            qijuOrderService.updateById(qijuOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<QijuOrderEntity> oldQijuOrderList =qijuOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        qijuOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<QijuOrderEntity> qijuOrderList = new ArrayList<>();//上传的东西
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
                            QijuOrderEntity qijuOrderEntity = new QijuOrderEntity();
//                            qijuOrderEntity.setQijuOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            qijuOrderEntity.setQijuId(Integer.valueOf(data.get(0)));   //器具 要改的
//                            qijuOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            qijuOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //租赁数量 要改的
//                            qijuOrderEntity.setQijuOrderTime(sdf.parse(data.get(0)));          //租赁时间 要改的
//                            qijuOrderEntity.setQijuOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            qijuOrderEntity.setQijuOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            qijuOrderEntity.setQijuOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            qijuOrderEntity.setInsertTime(date);//时间
//                            qijuOrderEntity.setCreateTime(date);//时间
                            qijuOrderList.add(qijuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("qijuOrderUuidNumber")){
                                    List<String> qijuOrderUuidNumber = seachFields.get("qijuOrderUuidNumber");
                                    qijuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> qijuOrderUuidNumber = new ArrayList<>();
                                    qijuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("qijuOrderUuidNumber",qijuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<QijuOrderEntity> qijuOrderEntities_qijuOrderUuidNumber = qijuOrderService.selectList(new EntityWrapper<QijuOrderEntity>().in("qiju_order_uuid_number", seachFields.get("qijuOrderUuidNumber")));
                        if(qijuOrderEntities_qijuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(QijuOrderEntity s:qijuOrderEntities_qijuOrderUuidNumber){
                                repeatFields.add(s.getQijuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        qijuOrderService.insertBatch(qijuOrderList);
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
        PageUtils page = qijuOrderService.queryPage(params);

        //字典表数据转换
        List<QijuOrderView> list =(List<QijuOrderView>)page.getList();
        for(QijuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QijuOrderEntity qijuOrder = qijuOrderService.selectById(id);
            if(qijuOrder !=null){


                //entity转view
                QijuOrderView view = new QijuOrderView();
                BeanUtils.copyProperties( qijuOrder , view );//把实体数据重构到view中

                //级联表
                    QijuEntity qiju = qijuService.selectById(qijuOrder.getQijuId());
                if(qiju != null){
                    BeanUtils.copyProperties( qiju , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setQijuId(qiju.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(qijuOrder.getYonghuId());
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
    * 前端详情
    */
    @RequestMapping("/guihuan")
    public R guihuan(Integer id){
        logger.debug("guihuan方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        QijuOrderEntity qijuOrder = qijuOrderService.selectById(id);
        if(qijuOrder ==null)
            return R.error(511,"查不到订单数据");

        QijuEntity qijuEntity = qijuService.selectById(qijuOrder.getQijuId());
        if(qijuEntity != null){
            qijuEntity.setQijuKucunNumber(qijuEntity.getQijuKucunNumber()+qijuOrder.getBuyNumber());

            qijuOrder.setQijuOrderTypes(106);
            qijuOrderService.updateById(qijuOrder);

            qijuService.updateById(qijuEntity);
        }
        return R.ok();
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody QijuOrderEntity qijuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,qijuOrder:{}",this.getClass().getName(),qijuOrder.toString());
            QijuEntity qijuEntity = qijuService.selectById(qijuOrder.getQijuId());
            if(qijuEntity == null){
                return R.error(511,"查不到该滑雪器具");
            }
            // Double qijuNewMoney = qijuEntity.getQijuNewMoney();

            if(false){
            }
            else if(qijuEntity.getQijuNewMoney() == null){
                return R.error(511,"租赁价格/天不能为空");
            }
            else if((qijuEntity.getQijuKucunNumber() -qijuOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - qijuEntity.getQijuNewMoney()*qijuOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            qijuOrder.setQijuOrderTypes(101); //设置订单状态为已申请租赁
            qijuOrder.setQijuOrderTruePrice(qijuEntity.getQijuNewMoney()*qijuOrder.getBuyNumber()); //设置实付价格
            qijuOrder.setYonghuId(userId); //设置订单支付人id
            qijuOrder.setQijuOrderUuidNumber(String.valueOf(new Date().getTime()));
            qijuOrder.setQijuOrderPaymentTypes(1);
            qijuOrder.setInsertTime(new Date());
            qijuOrder.setCreateTime(new Date());
                qijuEntity.setQijuKucunNumber( qijuEntity.getQijuKucunNumber() -qijuOrder.getBuyNumber());
                qijuService.updateById(qijuEntity);
                qijuOrderService.insert(qijuOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消申请
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            QijuOrderEntity qijuOrder = qijuOrderService.selectById(id);//当前表service
            Integer buyNumber = qijuOrder.getBuyNumber();
            Integer qijuOrderPaymentTypes = qijuOrder.getQijuOrderPaymentTypes();
            Integer qijuId = qijuOrder.getQijuId();
            if(qijuId == null)
                return R.error(511,"查不到该滑雪器具");
            QijuEntity qijuEntity = qijuService.selectById(qijuId);
            if(qijuEntity == null)
                return R.error(511,"查不到该滑雪器具");
            Double qijuNewMoney = qijuEntity.getQijuNewMoney();
            if(qijuNewMoney == null)
                return R.error(511,"滑雪器具价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(qijuOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = qijuEntity.getQijuNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            qijuEntity.setQijuKucunNumber(qijuEntity.getQijuKucunNumber() + buyNumber);

            qijuOrder.setQijuOrderTypes(102);//设置订单状态为已取消申请
            qijuOrderService.updateAllColumnById(qijuOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            qijuService.updateById(qijuEntity);//更新订单中滑雪器具的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer qijuCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            QijuOrderEntity qijuOrder = qijuOrderService.selectById(id);
        if(qijuOrder == null)
            return R.error(511,"查不到该订单");
        Integer qijuId = qijuOrder.getQijuId();
        if(qijuId == null)
            return R.error(511,"查不到该滑雪器具");

        QijuCommentbackEntity qijuCommentbackEntity = new QijuCommentbackEntity();
            qijuCommentbackEntity.setId(id);
            qijuCommentbackEntity.setQijuId(qijuId);
            qijuCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            qijuCommentbackEntity.setQijuCommentbackText(commentbackText);
            qijuCommentbackEntity.setInsertTime(new Date());
            qijuCommentbackEntity.setReplyText(null);
            qijuCommentbackEntity.setUpdateTime(null);
            qijuCommentbackEntity.setCreateTime(new Date());
            qijuCommentbackService.insert(qijuCommentbackEntity);

            qijuOrder.setQijuOrderTypes(105);//设置订单状态为已评价
            qijuOrderService.updateById(qijuOrder);//根据id更新
            return R.ok();
    }

    /**
     * 同意租赁
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        QijuOrderEntity  qijuOrderEntity = qijuOrderService.selectById(id);
        qijuOrderEntity.setQijuOrderTypes(103);//设置订单状态为已同意租赁
        qijuOrderService.updateById( qijuOrderEntity);

        return R.ok();
    }


}

