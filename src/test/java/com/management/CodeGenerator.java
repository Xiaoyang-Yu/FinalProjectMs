package com.management;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

/**
 * @author: Xiaoyang Yu
 * @create_at: 2023/4/19 6:29
 * @version: 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://gateway01.us-west-2.prod.aws.tidbcloud.com:4000/mydb";
        String username = "3zmK2DyYdCPQg3A.root";
        String password = "ZhXjlIOcMWJZow3x";
        String moduleName = "sys";
        String mapperLocation = "C:\\Users\\Fei\\IdeaProjects\\FinalProjectMs\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "Body_Fat_Percentage,"; //可以多张表，用，分割
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("Xiaoyang") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("C:\\Users\\Fei\\IdeaProjects\\FinalProjectMs\\src\\main\\java"); // 指定输出目录
                })
                /*.dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        // 自定义类型转换
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))*/
                .packageConfig(builder -> {
                    builder.parent("com.management") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("x"); // 设置过滤表前缀 "t_", "c_"
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
