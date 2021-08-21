package com.viking.dao.util;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.viking.dao.base.CommonDO;

import java.util.*;

/**
 * // 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
 *
 * @author jiangwei
 * @date 2021/08/21
 **/
public class MysqlGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
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
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        projectPath = projectPath + "/lol-dao";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("auto");
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setEntityName("%sDO");
//        gc.setServiceImplName("%sDomainService");
//        gc.setMapperName("%sDao");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();

        dsc.setUrl("jdbc:mysql://localhost:3306/lol?useUnicode=true&useSSL=false&characterEncoding=utf8");


        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("jw123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent("com.viking.dao");
        pc.setEntity("domain").setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        String finalProjectPath = projectPath;
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return finalProjectPath + "/src/main/resources/conf/mybatis/" + tableInfo.getMapperName() + StringPool.DOT_XML;
            }
        });

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
//         templateConfig.setService(null);
        templateConfig.setController(null);
//         templateConfig.setServiceImpl(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

//        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(CommonDO.class);
        strategy.setSuperMapperClass("com.viking.dao.base.CommonMapper");
        strategy.setSuperServiceImplClass("com.viking.dao.base.CommonServiceImpl");
        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
        // 公共父类
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns(new String[]{"id", "status", "env", "creator", "modifier", "gmt_create", "gmt_modified"});
        strategy.setTablePrefix("lol_");


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                //自定义配置，在模版中cfg.superColums 获取
                // TODO 这里解决子类会生成父类属性的问题，在模版里会用到该配置
                map.put("superColums", this.getConfig().getStrategyConfig().getSuperEntityColumns());
                this.setMap(map);
            }
        };

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        strategy.setInclude(scanner("表名（包含前缀）多个英文逗号分割").split(","));
//        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
