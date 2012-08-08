package moer.moerog.module.index;

import moer.moerog.module.comment.Comment;
import moer.moerog.module.user.User;
import moer.moerog.module.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("loginUser")
public class IndexController {
	@Autowired UserService userService;
	@Autowired IndexService indexService;
	
//	@ModelAttribute("enums")
//	public List<String> getCategory() {
//		List<String> categoryList = new ArrayList<String>();
//		
//		for (Category category : Category.values()) {
//			categoryList.add(category.name());
//		}
//		
//		return categoryList;
//	}
	
	@RequestMapping("/index")
	public String list(Comment comment, @ModelAttribute User loginUser, Model model) {
		Index index = new Index();
		indexService.setPostLIstTo(index);
		
		model.addAttribute("index", index);
		model.addAttribute("commentMap", indexService.getCommentMap(index.getPostMap()));
		
		return "index";
	}
}
