package com.ruoyi.web.controller.tool;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import org.apache.catalina.connector.CoyoteOutputStream;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
@RequestMapping("/tool/pdf2ofd")
public class Pdf2ofdController {

    @Autowired
    private ServerConfig serverConfig;

    private final String prefix = "tool/build";

    @RequiresPermissions("tool:pdf2ofd:view")
    @GetMapping()
    public String build()
    {
        return prefix + "/pdf2ofd";
    }

    @RequiresPermissions("tool:pdf2ofd:convert")
    @PostMapping("/convert")
    public ResponseEntity<InputStreamResource> convert(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        try {
        String originalFilename = file.getOriginalFilename();
        String nameNotSuffix = FileUtils.getNameNotSuffix(originalFilename);
        String outFileName = nameNotSuffix + ".ofd";
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromStream(file.getInputStream());

        // 转换为OFD格式并保存到输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        pdf.saveToStream(out, FileFormat.OFD);


        // 创建输入流
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        InputStreamResource resource = new InputStreamResource(in);
        String fileNameUTF = URLEncoder.encode(outFileName, "UTF-8");
        ResponseEntity<InputStreamResource> body = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileNameUTF)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(out.size())
                .body(resource);
        return body;
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
