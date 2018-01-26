package com.dranawhite.common.mybatis;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 根据数据库备注生成实体注释
 *
 * @author liangyq 2018/1/26
 */
public class DbCommentGenerator implements CommentGenerator {

    /**
     * properties配置
     */
    private Properties properties;

    /**
     * 是否生成日期注释
     */
    private boolean suppressDate;

    /**
     * 是否生成所有注释
     */
    private boolean suppressAllComments;

    /**
     * 表额外注释
     * 若suppressAllComments设置为true，则忽略该字段
     */
    private boolean addRemarkComments;

    private SimpleDateFormat dateFormat;

    /**
     * 实体类备注
     */
    private String modelComment;

    /**
     * 类文件创建者
     */
    private String author;

    /**
     * 类文件版本号
     */
    private String version;

    /**
     * 是否生成@Alias注解
     */
    private boolean suppressModelAlias;

    public DbCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
        author = null;
        version = null;
        modelComment = null;
        suppressModelAlias = true;
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
        addRemarkComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));
        suppressModelAlias = isTrue(properties
                .getProperty(DbPropertyRegistry.COMMENT_GENERATOR_SUPPRESS_MODEL_ALIAS));
        author = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_AUTHOR);
        version = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_VERSION);
        modelComment = properties.getProperty(DbPropertyRegistry.COMMENT_GENERATOR_MODEL_COMMENT);
        String dateFormatString =
                properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        if (introspectedColumn == null) {
            return;
        }

        field.addJavaDocLine("/**");
        String remark = introspectedColumn.getRemarks();
        StringBuilder sb = new StringBuilder(" * ");
        sb.append(remark);
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        addFieldComment(field, introspectedTable, null);
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        if (suppressAllComments  || !addRemarkComments) {
            return;
        }

        topLevelClass.addJavaDocLine("/**");
        String remark = introspectedTable.getRemarks();
        if (modelComment != null) {
            remark = modelComment;
        }
        if (remark != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * ").append(remark);
            topLevelClass.addJavaDocLine(sb.toString());
        }
        if (author != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(" * @author ").append(author);
            topLevelClass.addJavaDocLine(sb.toString());
        }
        if (version != null) {
            StringBuilder sb = new StringBuilder();
            Date curTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String curFormattedTime = sdf.format(curTime);
            sb.append(" * @version [V").append(version).append(", ").append(curFormattedTime)
                    .append("]");
            topLevelClass.addJavaDocLine(sb.toString());
        }
        topLevelClass.addJavaDocLine(" */");
        if (!suppressModelAlias) {
            String annotation = "@Alias(\"" + topLevelClass.getType().getShortName() + "\")";
            topLevelClass.addAnnotation(annotation);
            topLevelClass.addImportedType("org.apache.ibatis.type.Alias");
        }
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        System.out.println("addclassComment 1");
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable,
            boolean markAsDoNotDelete) {
        System.out.println("addClassComment 2");
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        // Do Nothing
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        method.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder(" * @return the ");
        String methodName = method.getName();
        char[] methodNameChs = methodName.toCharArray();
        methodNameChs[3] = (char) (methodNameChs[3] + 32);
        char[] fieldNameChs = Arrays.copyOfRange(methodNameChs, 3, methodNameChs.length);
        sb.append(fieldNameChs);
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }

        method.addJavaDocLine("/**");
        StringBuilder sb = new StringBuilder(" * @param ");
        List<Parameter> paramList = method.getParameters();
        String fieldName = paramList.get(0).getName();
        sb.append(fieldName).append(" the ").append(fieldName).append(" to set");
        method.addJavaDocLine(sb.toString());
        method.addJavaDocLine(" */");
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        // Do Nothing
    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        compilationUnit.addFileCommentLine("/*");
        compilationUnit.addFileCommentLine(" * Copyright (C), 2015-2018, 上海米么金融信息服务有限公司");
        compilationUnit.addFileCommentLine(" * FileName:     " + compilationUnit.getType().getShortName());
        compilationUnit.addFileCommentLine(" * Author:       " + author);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        compilationUnit.addFileCommentLine(" * Date:         " + sdf.format(new Date()));
        compilationUnit.addFileCommentLine(" * Description:  模块目的、功能描述");
        compilationUnit.addFileCommentLine(" * History:      修改记录");
        compilationUnit.addFileCommentLine(" * <author>              <time>             <version>" +
                "               <desc>");
        compilationUnit.addFileCommentLine(" * 修改人姓名             修改时间            版本号             " +
                "     描述");
        compilationUnit.addFileCommentLine(" */");
    }

    @Override
    public void addComment(XmlElement xmlElement) {
        // Do Nothing
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        // Do Nothing
    }
}
