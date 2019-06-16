package mp.test.controllers;

import mp.test.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author chenjian
 * @date 2019/3/18 13:23
 * @Description
 */
@Controller
@RequestMapping("upload")
public class uploadController {

    /**
     * 文件上传方法
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("fileUpload")
    public String uploadFile(@RequestParam MultipartFile uploadFile,HttpSession session,Model model) {
        //文件读写要用到绝对路径,把相对路径转换为绝对路径

        String oldFileName = uploadFile.getOriginalFilename();
        String filePath = FileUploadUtil.fileUpload(uploadFile, session, "upload");
        model.addAttribute("filePath", filePath);
        model.addAttribute("oldFileName", oldFileName);
        return "show-file";
    }

}
