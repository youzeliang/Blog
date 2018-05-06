package com.lyz.blog.service;


import com.lyz.blog.modal.vo.OptionVo;

import java.util.List;
import java.util.Map;

/**
 * options的接口
 * Created by llyz.
 */
public interface IOptionService {

    void insertOption(OptionVo optionVo);

    void insertOption(String name, String value);

    List<OptionVo> getOptions();


    /**
     * 保存一组配置
     *
     * @param options
     */
    void saveOptions(Map<String, String> options);
}
