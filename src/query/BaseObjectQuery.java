package query;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
/**
 * 查询基类
 */
@Data
abstract public class BaseObjectQuery implements IQuery{
	
	private Integer currentPage=1;
	private Integer pageSize=3;

	private List<String> condition = new ArrayList<>();
	//　这是高级查询结果并且实现分页的sql语句
	public String getQuerySql() {
		this.costumoize1();

		StringBuilder sql = new StringBuilder("SELECT * FROM product ");

		for (int i = 0; i < condition.size(); i++) {
			
			if (i == condition.size()-1 ) {
				sql.append(condition.get(i));
				break;
			} else if(i == 0){
				sql.append("WHERE");
			}else {
				sql.append("AND");
			}
			sql.append(condition.get(i));
			
		}
		condition.clear();
		return sql.toString();
		
	}
	// 这是查询记录总数的sql语句
	public String getCountSql() {
		StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM product ");
		this.costuomize();

		for (int i = 0; i < condition.size(); i++) {
			if (i == 0) {
				sql.append("WHERE");
			} else {
				sql.append("AND");
			}
			sql.append(condition.get(i));
			
		}
		condition.clear();
		return sql.toString();
	}

	abstract protected void costuomize();
	protected void costumoize1() {};
	protected void addQuery(String sql) {
		condition.add(sql);

	}
	@Override
	public Integer getBeginIndex() {
		
		return (currentPage-1)*pageSize;
	}

}
