package ImageHoster.controller;


import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addComments(@PathVariable("title") String title,
           @PathVariable("imageId") Integer imageId,
           @RequestParam("comment") String comment,HttpSession session) throws  IOException{
     System.out.println(comment);
     Comments userComments = new Comments();
        userComments.setText(comment);
        userComments.setCreateDate(LocalDate.now());
        Image image = imageService.getImage(imageId);
        userComments.setImage(image);
        userComments.setUser((User) session.getAttribute("loggedUser"));
        commentService.addComment(userComments);
        return "redirect:/images" + imageId + "/" + "title";




    }
}
