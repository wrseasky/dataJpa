package com.baidu.excepAspect.globalException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by Jhon on 2018/3/31.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(HttpServletRequest req,Exception e){
        //是返回的String.

        //ModelAndView -- 介绍 模板引擎...?
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName(viewName);

        return "对不起，服务器繁忙，请稍后再试！";
    }

}
