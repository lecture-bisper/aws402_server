//  File :  FileUtils.java
//  User :  it
//  Date :  2026-08-18
//  Time :  오후 3:13
//  Desc :  

package bitc.aws402.board2.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
public class FileUtils {

  @Value("${file.upload-dir}")
  private String uploadDir;

  private Path resolveUploadPath() {
    Path path = Paths.get(uploadDir).toAbsolutePath().normalize();

    try {
      Files.createDirectories(path);
    }
    catch (IOException e) {
      throw new RuntimeException("업로드 폴더를 생성할 수 없습니다.", e);
    }
    return path;
  }

  public String store(InputStream inputStream, String originalFileName) {
    String ext = "";

    int dotIdx = originalFileName.lastIndexOf(".");

    if (dotIdx > -1) {
      ext = originalFileName.substring(dotIdx);
    }
    String storedName = UUID.randomUUID() + ext;

    Path target = resolveUploadPath().resolve(storedName);

    try {
      Files.copy(inputStream, target, StandardCopyOption.REPLACE_EXISTING);
    }
    catch (IOException e) {
      throw new RuntimeException("파일 저장에 실패했습니다." + originalFileName, e);
    }
    return storedName;
  }

  public Path resolve(String storedFileName) {
    return resolveUploadPath().resolve(storedFileName);
  }

  public void delete(String storedFileName) {
    try {
      Files.deleteIfExists(resolve(storedFileName));
    }
    catch (IOException e) {
      System.out.println("파일 삭제 실패" + storedFileName);
    }
  }

  public String sanitizeFileName(String fileName) {
    return StringUtils.cleanPath(fileName);
  }
}











