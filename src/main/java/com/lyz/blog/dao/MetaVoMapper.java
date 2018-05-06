package com.lyz.blog.dao;

import com.lyz.blog.dto.MetaDto;
import com.lyz.blog.modal.vo.MetaVo;
import com.lyz.blog.modal.vo.MetaVoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author youzeliang
 * on 2018/5/6
 */
@Component
public interface MetaVoMapper {
    long countByExample(MetaVoExample example);

    int deleteByExample(MetaVoExample example);

    int deleteByPrimaryKey(Integer mid);

    int insert(MetaVo record);

    int insertSelective(MetaVo record);

    List<MetaVo> selectByExample(MetaVoExample example);

    MetaVo selectByPrimaryKey(Integer mid);

    int updateByExampleSelective(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    int updateByExample(@Param("record") MetaVo record, @Param("example") MetaVoExample example);

    int updateByPrimaryKeySelective(MetaVo record);

    int updateByPrimaryKey(MetaVo record);

    List<MetaDto> selectFromSql(Map<String, Object> paraMap);

    MetaDto selectDtoByNameAndType(@Param("name") String name, @Param("type") String type);

    Integer countWithSql(Integer mid);
}
