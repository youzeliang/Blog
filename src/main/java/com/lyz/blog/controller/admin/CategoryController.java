package com.lyz.blog.controller.admin;

import com.lyz.blog.constant.WebConst;
import com.lyz.blog.controller.BaseController;
import com.lyz.blog.dto.MetaDto;
import com.lyz.blog.dto.Types;
import com.lyz.blog.exception.TipException;
import com.lyz.blog.modal.bo.RestResponseBo;
import com.lyz.blog.service.IMetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author youzeliang
 * on 2018/5/6
 */
@Controller
@RequestMapping("admin/category")
public class CategoryController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private IMetaService metasService;

    /**
     * 分类页
     * @param request
     * @return
     */
    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<MetaDto> categories = metasService.getMetaList(Types.CATEGORY.getType(), null, WebConst.MAX_POSTS);
        List<MetaDto> tags = metasService.getMetaList(Types.TAG.getType(),  null, WebConst.MAX_POSTS);
        request.setAttribute("categories", categories);
        request.setAttribute("tags", tags);
        return "admin/category";
    }

    @PostMapping(value = "save")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo saveCategory(@RequestParam String cname, @RequestParam Integer mid) {
        try {
            metasService.saveMeta(Types.CATEGORY.getType(),cname,mid);
        } catch (Exception e) {
            String msg = "分类保存失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    /**
     * 删除分类
     * @param mid
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    @Transactional(rollbackFor = TipException.class)
    public RestResponseBo delete(@RequestParam int mid) {
        try {
            metasService.delete(mid);
        } catch (Exception e) {
            String msg = "删除失败";
            if (e instanceof TipException) {
                msg = e.getMessage();
            } else {
                LOGGER.error(msg, e);
            }
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
