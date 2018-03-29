package query;

import java.util.List;

import domain.Product;
/**
 * 分页的对象封装
 * 
 */
public class PageList {
	private List<Product> pageListData;
	// 集合中存储的是结果的封装(商品的集合)
	private Integer totalCount; // 总记录数
	private Integer beginPage; // 开始页
	private Integer currentPage; // 当前页
	private Integer pageSize; // 一页显示多少
	
	
	//private Integer prePage; //   上一页
	//private Integer nextPage; // 下一页
	//private Integer pageCount; // 最后一页,总页数

	public PageList(List<Product> pageList, Integer count, Integer currentPage2, Integer pageSize2) {
		this.pageListData = pageList;
		this.totalCount = count;
		this.currentPage = currentPage2;
		this.pageSize = pageSize2;
	}


	public Integer getNextPage() {
		return currentPage + 1 <= getPageCount() ? currentPage + 1 : getPageCount();
	}

	public Integer getPageCount() {
		return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

	public Integer getPrePage() {
		return currentPage - 1 >= 1 ? currentPage - 1 : 1;
	}

	public List<Product> getPageListData() {
		return pageListData;
	}

	public void setPageListData(List<Product> pageListData) {
		this.pageListData = pageListData;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getBeginPage() {
		return beginPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
