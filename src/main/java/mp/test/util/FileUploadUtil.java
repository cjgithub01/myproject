package mp.test.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author chenjian
 * @date 2019/3/18 13:25
 * @Description
 */
public class FileUploadUtil {
    /**
     * 封装后的上传方法
     * @param uploadFile
     * @param session
     * @param savePath
     * @return
     */
    public static String fileUpload(MultipartFile uploadFile, HttpSession session,
                                    String savePath) {
        // 文件读写要用到绝对路径，把相对路径转换为绝对路径
        String realPath = session.getServletContext().getRealPath(
                "files/" + savePath);
        System.out.println("绝对路径：" + realPath);
        // 取原文件的名称
        String oldFilename = uploadFile.getOriginalFilename();
        // 获取原文件名称后缀
        String suffix = oldFilename.substring(oldFilename.lastIndexOf("."));
        // 新文件名称(为了防止同名文件覆盖，保证文件名称不重复)
        String newFileName = UUID.randomUUID() + suffix;
        // 根据上面的绝对路径和新文件名称，创建file对象
        File file = new File(realPath, newFileName);
        if (!file.exists()) {// 如果文件不存在
            file.mkdirs();// 创建父目录
        }

        try {
            // 调用封装后的文件读写方法，把原文件内容读写新文件里面
            uploadFile.transferTo(file);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "files/" + savePath + "/" + newFileName;
    }
}

