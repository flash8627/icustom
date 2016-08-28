package com.gwtjs.international.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.international.dao.InternationalDAO;
import com.gwtjs.international.entity.LanguageVO;
import com.gwtjs.international.services.IInternationalService;

/**
 * 国际化
 * 
 * @author aGuang
 *
 */
@Named("internationalService")
public class InternationalServiceImpl implements IInternationalService {

	@Inject
	private InternationalDAO internationalDao;
	
	/**
	 * 分页的lookup 条目
	 */
	@Override
	public PagedResult<LanguageVO> findListRecords(LanguageVO record, PagerVO page) {
		PagedResult<LanguageVO> paged = new PagedResult<LanguageVO>();
		PagerVO pageVO = new PagerVO();
		pageVO.setTotalRows(internationalDao.selectListCount(record,page));
		if(pageVO.getTotalRows()>0){
			paged.setPageVO(pageVO);
			paged.setResult(internationalDao.selectList(record, page));
		}
		return paged;
	}
	
	@Override
	public ResultWrapper findItem(Long regId) {
		// TODO Auto-generated method stub
		return ResultWrapper.successResult(internationalDao.findItem(regId));
	}

	@Override
	public List<LanguageVO> findLanguageList(LanguageVO record, PagerVO page) {
		return internationalDao.selectList(record, page);
	}

	@Override
	public ResultWrapper findLanguageListCount(LanguageVO record) {
		return ResultWrapper.successResult(internationalDao.selectListCount(record));
	}

	@Override
	public ResultWrapper batchRemovePks(List<LanguageVO> records) {
		return ResultWrapper.successResult(internationalDao.batchRemovePks(records));
	}

	@Override
	public ResultWrapper batchUpdate(List<LanguageVO> records) {
		return ResultWrapper.successResult(internationalDao.batchUpdate(records));
	}

	@Override
	public ResultWrapper batchInsert(List<LanguageVO> records) {
		return ResultWrapper.successResult(internationalDao.batchInsert(records));
	}

}
