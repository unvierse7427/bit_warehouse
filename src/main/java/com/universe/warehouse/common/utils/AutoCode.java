package com.universe.warehouse.common.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码自动生成工具
 * ClassName: AutoCode
 * Description:
 * date: 2020/11/16 9:15
 *
 * @author Handsome xuanxuan
 */
public class AutoCode {

    public void AutoCreateCode(String tableName) {
        AutoGenerator mpg = new AutoGenerator();

        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("universe7427");   // 作者
        gc.setSwagger2(true);//实现swagger2注解
        gc.setOpen(false);      //生成代码后是否打开文件夹
        gc.setServiceName("%sService");  // 设置Service接口生成名称,这样生成接口前面就不会有 I
        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);//设置数据库类型为其它
        dsc.setUrl("jdbc:mysql://localhost:3306/bit_warehouse");
        dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        pc.setModuleName("sys"); // 模块名称, 这里可以根据不同模块来写
        pc.setParent("com.universe.warehouse"); // 父包名
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperControllerClass("com.hmhc.mts.controller");
//        strategy.setSuperEntityClass("com.hmhc.mts.entity");
//        strategy.setTablePrefix("tb_");//表格前缀
        strategy.setEntityLombokModel(true);
        //人大金仓数据库，注意大写
        strategy.setInclude(tableName);  // 如果要生成多个,这里可以传入String[]
        mpg.setStrategy(strategy);
        mpg.execute();
    }
    public static void main(String[] args) {

        AutoCode autoCode = new AutoCode();

        autoCode.AutoCreateCode("bw_document_message");

    }
}
