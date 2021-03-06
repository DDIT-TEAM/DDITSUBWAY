package dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import service.MenuService;
import util.JDBCUtil;
import util.ScanUtil;
import util.View;

public class MenuDao {
	//switch문에 default 꼭 입력 
	private MenuDao(){}
	private static MenuDao instance;
	public static MenuDao getInstance(){
		if(instance == null){
			instance = new MenuDao();
		}
		return instance;
	}

	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectMenuList(String menuGu){
		String sql = "select MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM,"
				+ "MENU_INGR, MENU_PRICE from menu "
				+ "where MENU_GU = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(menuGu);
		return jdbc.selectList(sql, param);
	}
	//고객, 가맹점주 메뉴 조회
	
	public Map<String, Object> selectsandDet(int detSDNum){
		
		String sql = " select MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM, MENU_INGR, MENU_PRICE, "
				+ "(select  max(MENU_GU_SEQ) from menu where MENU_GU = 'SD') as maxgs "
				+ "from menu "
				+ "where MENU_NO = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(detSDNum);
		return jdbc.selectOne(sql, param);
	}
	//고객, 가맹점주 - 샌드위치 메뉴 조회
	
	public Map<String, Object> selectwrapDet(int detWRNum){
		String sql = " select MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM, MENU_INGR, MENU_PRICE, "
				+ "(select  max(MENU_GU_SEQ) from menu where MENU_GU = 'SD') as maxgs "
				+ "from menu "
				+ "where MENU_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(detWRNum);
		return jdbc.selectOne(sql, param);
	}
	//고객, 가맹점주 - 랩 메뉴 조회

	public Map<String, Object> selectsallDet(int detSLNum){
		String sql = " select MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM, MENU_INGR, MENU_PRICE, "
				+ "(select  max(MENU_GU_SEQ) from menu where MENU_GU = 'SD') as maxgs "
				+ "from menu "
				+ "where MENU_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(detSLNum);
		return jdbc.selectOne(sql, param);
	}
	//고객, 가맹점주 - 샐러드 메뉴 조회
	
	
	public List<Map<String, Object>> selAllMenuList(){
		String sql = " select MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM, MENU_INGR, MENU_PRICE,"
				+ "(select  max(MENU_GU_SEQ) from menu where MENU_GU = 'SD') as maxgs "
				+ "from menu ";

		List<Map<String, Object>> selAMenuList = jdbc.selectList(sql);
		return jdbc.selectList(sql);
	}
	//관리자 메뉴 관리 전 전체조회(등록, 수정, 삭제)
	
	public int entMenu(String menuGu, String menuNM, String menuIngr, int menuPri){
		String sql = "INSERT INTO MENU("
				+ "MENU_NO, MENU_GU, MENU_GU_SEQ, MENU_NM, MENU_INGR, MENU_PRICE) "
				+ "VALUES(MENU_NO_SEQ.NEXTVAL, ?, MENU_" + menuGu + "_SEQ.NEXTVAL, ?, ?, ?)";
		List<Object> param = new ArrayList<>();
		param.add(menuGu);
		param.add(menuNM);
		param.add(menuIngr);
		param.add(menuPri);
		return jdbc.update(sql, param);
	}
	//관리자 - 메뉴 등록
	
	public int updMenu(int menuNo, String menuGu, String menuNM, String menuIngr, int menuPri){
		String sql = "UPDATE MENU "
				+ "SET MENU_GU = ?, MENU_NM = ?, MENU_INGR = ?, MENU_PRICE = ? "
				+ "WHERE MENU_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(menuGu);
		param.add(menuNM);
		param.add(menuIngr);
		param.add(menuPri);
		param.add(menuNo);
		
		return jdbc.update(sql, param);
	}
	//관리자 - 메뉴 수정
	
	public int delMenu(int menuNo){
		String sql = "DELETE FROM MENU WHERE MENU_NO = ?";

		List<Object> param = new ArrayList<>();
		param.add(menuNo);
		
		return jdbc.update(sql, param);
	}
	//관리자 - 메뉴 삭제
}
