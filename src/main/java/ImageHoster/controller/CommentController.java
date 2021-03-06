package ImageHoster.controller;

import ImageHoster.model.Comments;
import ImageHoster.model.Image;
import ImageHoster.model.Tag;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@Controller
public class CommentController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private CommentService commentService;

    //This will add a Comment for a particular image
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String addComments(@PathVariable("imageTitle") String imageTitle,
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
     return "redirect:/images/" + imageId+ "/" + imageTitle;
    }
}
