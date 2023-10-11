package com.elasticsearch.demo.service.content;

import com.elasticsearch.demo.controller.dto.content.DeleteContentDocumentParam;

public interface DeleteContentDocumentService {

    public void deleteDocument(DeleteContentDocumentParam param);
}
