package com.j2ee.util;
import java.util.ArrayList;
import java.util.List;

import com.j2ee.pojo.Role;

@SuppressWarnings("unchecked")
public class PageBean<T> {
	
	     private List<T> list = new ArrayList<T>();
	      
	     private int allRow; // 鎬昏褰曟暟
	     private int totalPage; // 鎬婚〉鏁�	     
	     private int currentPage; // 褰撳墠椤�	     
	     private int pageSize;// 姣忛〉璁板綍鏁�	     
	     @SuppressWarnings("unused")
	     private boolean isFirstPage; // 鏄惁涓虹涓�〉
	     @SuppressWarnings("unused")
	     private boolean isLastPage;// 鏄惁涓烘渶鍚庝竴椤�	     
	     @SuppressWarnings("unused")
	     private boolean hasPreviousPage; // 鏄惁鏈夊墠涓�〉
	     @SuppressWarnings("unused")
	     private boolean hasNextPage;// 鏄惁鏈変笅涓�〉
	 
	     
	 
	     public List<T> getList() {
			return list;
		}

		public void setList(List<T> list) {
			this.list = list;
		}

		public int getAllRow() {
	         return allRow;
	     }
	 
	     public void setAllRow(int allRow) {
	         this.allRow = allRow;
	     }
	 
	     public int getTotalPage() {
	         return totalPage;
	     }
	 
	     public void setTotalPage(int totalPage) {
	         this.totalPage = totalPage;
	     }
	 
	     public int getCurrentPage() {
	         return currentPage;
	     }
	 
	     public void setCurrentPage(int currentPage) {
	         this.currentPage = currentPage;
	     }
	 
	     public int getPageSize() {
	         return pageSize;
	     }
	 
	     public void setPageSize(int pageSize) {
	         this.pageSize = pageSize;
	     }
	 
	     /**
	      * 鍒濆鍖栧垎椤典俊鎭�	      */
	     public void init() {
	         this.isFirstPage = isFirstPage();
	         this.isLastPage = isLastPage();
	         this.hasPreviousPage = isHasPreviousPage();
	         this.hasNextPage = isHasNextPage();
	     }
	 
	     /**
	      * 浠ヤ笅鍒ゆ柇椤电殑淇℃伅,鍙渶getter鏂规硶(is鏂规硶)鍗冲彲
	      * 
	      * @return
	      */
	     public boolean isFirstPage() {
	         return currentPage == 1; // 濡傛槸褰撳墠椤垫槸绗�椤�	     
	     }
	 
	     public boolean isLastPage() {
	         return currentPage == totalPage; // 濡傛灉褰撳墠椤垫槸鏈�悗涓�〉
	     }
	 
	     public boolean isHasPreviousPage() {
	         return currentPage != 1;// 鍙褰撳墠椤典笉鏄1椤�	     
	         }
	 
	     public boolean isHasNextPage() {
	         return currentPage != totalPage; // 鍙褰撳墠椤典笉鏄渶鍚�椤�	     
	         }
	 
	     /**
	    * 璁＄畻鎬婚〉鏁�闈欐�鏂规硶,渚涘閮ㄧ洿鎺ラ�杩囩被鍚嶈皟鐢�	     * 
	    * @param pageSize姣忛〉璁板綍鏁�	     * @param allRow鎬昏褰曟暟
	     * @return 鎬婚〉鏁�	     */
	    public static int countTotalPage(final int pageSize, final int allRow) {
	        int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
	        return totalPage;
	    }
	
	    /**
	     * 璁＄畻褰撳墠椤靛紑濮嬭褰�	     * 
	     * @param pageSize姣忛〉璁板綍鏁�	     * @param currentPage褰撳墠绗嚑椤�	     * @return 褰撳墠椤靛紑濮嬭褰曞彿
	     */
	    public static int countOffset(final int pageSize, final int currentPage) {
	        final int offset = pageSize * (currentPage - 1);
	        return offset;
	    }
	
	    /**
	     * 璁＄畻褰撳墠椤�鑻ヤ负0鎴栬�璇锋眰鐨刄RL涓病鏈�?page=",鍒欑敤1浠ｆ浛
	     * 
	     * @paramPage 浼犲叆鐨勫弬鏁�鍙兘涓虹┖,鍗�,鍒欒繑鍥�)
	     * @return 褰撳墠椤�	     */
	    public static int countCurrentPage(int page) {
	        final int curPage = (page == 0 ? 1 : page);
	        return curPage;
	    }
}


