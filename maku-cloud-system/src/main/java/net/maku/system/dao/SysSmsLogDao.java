package net.maku.system.dao;

import net.maku.framework.mybatis.dao.BaseDao;
import net.maku.system.entity.SysSmsLogEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 短信日志
 *
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface SysSmsLogDao extends BaseDao<SysSmsLogEntity> {

}