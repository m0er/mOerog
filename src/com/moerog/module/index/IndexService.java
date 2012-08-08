package com.moerog.module.index;

import org.springframework.web.servlet.ModelAndView;

public interface IndexService {

	void setPostLIstTo(Index index);

	void setCommentListTo(ModelAndView mav);

}
