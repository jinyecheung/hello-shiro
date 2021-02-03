package com.example.hello.shiro.util;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 自动生成mybatis-plus代码
 */
public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 方式1单个生成
        // inputMethod1();
        // 方式2批量生成
       inputMethod2();
    }

    public static Map inputParams(String moduleName, String tableName, String apiRemark) {
        Map<String, String> map = new HashMap<>(16);
        map.put("moduleName", moduleName);
        map.put("tableName", tableName);
        map.put("apiRemark", apiRemark);
        System.out.println("模块名:" + moduleName + ",表名:" + tableName + ",swagger2控制层说明:" + apiRemark);
        return map;
    }

    /**
     * 方式2批量生成
     */
    public static void inputMethod2() {
        List<Map<String, String>> maps = new ArrayList<>();
        maps.add(inputParams("menu", "t_sys_menu", "菜单表"));
       // maps.add(inputParams("field", "PERSONNEL_FIELD_VALUE", "人员扩展字段值表"));

        for (Map<String, String> one : maps) {
            codeGen(one);
        }
    }

    /**
     * 方式1单个生成
     */
    public static void inputMethod1() {
        Map<String, String> map = inputParams(scanner("模块名"), scanner("表名"), scanner("表描述"));
        codeGen(map);
    }

    public static void codeGen(Map<String, String> map) {
        //入参
        String moduleName = map.get("moduleName");
        String tableName = map.get("tableName");
        String apiRemark = map.get("apiRemark");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 创建的文件输出目录
        gc.setOutputDir(projectPath + "/src/main/java");
        // 覆盖已有文件
        gc.setFileOverride(true);
        //作者
        gc.setAuthor("JinyeCheung");
        gc.setOpen(false);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/hello_shiro?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        //自定义父级包
        pc.setParent("com.example.hello.shiro");
        //自定义Controller
        pc.setController("controller." + moduleName);
        //自定义Entity
        pc.setEntity("pojo." + moduleName);
        //自定义Service
        pc.setService("service." + moduleName);
        //自定义ServiceImpl
        pc.setServiceImpl("service." + moduleName + ".impl");
        //自定义mapper
        pc.setMapper("mapper." + moduleName);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                // to do nothing
                Map<String, Object> map = new HashMap<>();
                //返回结果类导入路径
                map.put("ApiRemark", apiRemark);
                map.put("ResultInfoUrl", "com.example.hello.shiro.pojovo");
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                // + pc.getModuleName()+ "/"
                return projectPath + "/src/main/resources/mapper/" + moduleName + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        //自定义控制层模版
        templateConfig.setController("templates/Controller.java");
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
///        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
///        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        strategy.setInclude(tableName);
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
