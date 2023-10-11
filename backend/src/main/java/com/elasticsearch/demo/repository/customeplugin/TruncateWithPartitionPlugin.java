package com.elasticsearch.demo.repository.customeplugin;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.xml.*;

import java.util.List;

public class TruncateWithPartitionPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;  // 常にtrueを返すか、必要に応じてバリデーションロジックを追加
    }

    @Override
    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

        if (!"app_user".equals(introspectedTable.getFullyQualifiedTableNameAtRuntime())) {
            return true;  // 対象のテーブル名と一致しない場合はスキップ
        }


        XmlElement parentElement = document.getRootElement();

        // 新しいSQL要素を作成
        XmlElement truncateElement = new XmlElement("delete");
        truncateElement.addAttribute(new Attribute("id", "truncateWithPartition"));
        truncateElement.addElement(new TextElement("TRUNCATE TABLE test WITH (PARTITIONS (#{partitionNumber}))"));

        // XMLドキュメントに新しい要素を追加
        parentElement.addElement(truncateElement);

        return true;
    }
}
