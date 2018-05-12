<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script type="text/javascript">
	function goPage(pageNo){
		
		document.getElementById("currentPageId").value=pageNo;
		document.forms[0].submit(); 
	}

</script>
	<%-- <tr align="center"  >
			<td colspan="8">
			<a class="btn btn-default" href='javascript:void(0)'  onclick="goPage(1)">首页 </a>	
			<a class="btn btn-default" href='javascript:void(0)' onclick="goPage(${products.prePage})">上一页  </a> |
			<a class="btn btn-default" href='javascript:void(0)' onclick="goPage(${products.nextPage})">下一页		</a>
			<a class="btn btn-default" href='javascript:void(0)' onclick="goPage(${products.pageCount})">末页</a>
			当前第${products.currentPage}/${products.pageCount}页,一共${products.totalCount}条记录
			</td> 
			
			
			<tr > --%>
			<ul class="pagination "   >
           
            <li class="">  <a href='javascript:void(0)'  onclick="goPage(1)">首页 </a>  </li> 
            <li> <a href='javascript:void(0)'  onclick="goPage(${products.prePage})">上一页  </a> </li>
            <li> <a  href='javascript:void(0)'  onclick="goPage(${products.nextPage})">下一页     </a></li>
            <li> <a  href='javascript:void(0)'  onclick="goPage(${products.pageCount})">末页</a></li>
            <span class="label label-success">${products.currentPage}/${products.pageCount}</span>
			
		       </ul>
