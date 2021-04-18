package com.tank.spike.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.tank.spike.anno.Router;
import com.tank.spike.constants.UrlPrefix;
import com.tank.spike.protocol.resp.ResultApi;
import com.tank.spike.protocol.resp.ResultApiWrapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * @author tank198435163.com
 */
@Slf4j
@Router("文件上传下载管理")
public class FileCtrl {

  @SneakyThrows
  @PostMapping(value = UrlPrefix.URL_FOR_FILE_UPLOAD)
  public ResultApi<String> uploadFile(@NonNull @RequestParam("file") final MultipartFile file,
                                      @NonNull final @RequestParam("name") String name) {
    val path = System.getProperty("user.dir");
    val uploadPath = StrUtil.format("{}/{}/", path, "upload");
    val uploadDir = new File(uploadPath);
    log.info("received name:[{}]", name);
    synchronized (lock) {
      if (!this.fileDirCache.containsKey(uploadPath)) {
        if (!uploadDir.exists() && uploadDir.mkdirs()) {
          log.info("create dir success");
        }
        this.fileDirCache.putIfAbsent(uploadPath, 1);
      }
    }

    FileUtil.writeBytes(file.getBytes(), uploadPath + file.getOriginalFilename());
    return ResultApiWrapper.payLoad("success");
  }

  @GetMapping(value = UrlPrefix.URL_FOR_FILE_DOWNLOAD)
  public void download(@NonNull @PathVariable("name") String name, @NonNull final HttpServletResponse response) throws Exception {
    val path = System.getProperty("user.dir");
    val targetFilePath = StrUtil.format("{}/{}/{}", path, "upload", name);
    val file = new File(targetFilePath);
    if (!file.exists()) {
      throw new IllegalAccessException(StrUtil.format("{} not exists", name));
    }
    val mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
    response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
    response.setContentLength((int) file.length());
    response.setContentType(mimeType);

    try (val in = new BufferedInputStream(new FileInputStream(file))) {
      FileCopyUtils.copy(in, response.getOutputStream());
    }

  }

  private final Map<String, Integer> fileDirCache = Maps.newConcurrentMap();

  private final byte[] lock = new byte[1];

}
