package teamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

	Connection conn = null;  //Connection타입의 conn에 null값 넣기
	PreparedStatement pstmt = null;  //PreparedStatement타입의 pstmt에 null값 넣기

	//Connection타입의 dbconnect 메소드 생성
	public Connection dbconnect() {
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			//디비를 사용가능하게 오라클드라이버 적기
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클디비 ip랑 id,비번을 conn에 담는다
			conn = DriverManager.getConnection("Jdbc:oracle:thin:@192.168.0.57:1521:xe", "hr", "hr");

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return conn;  //리턴값은 conn
	}

	//Customer타입의 dbcustomer메소드 생성. 입력받는 값은 String str
	public Customer dbcustomer(String str) {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		String sql = "select * from customer";  // sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			
			//while문을 사용하여 rs.next()의 조건으로 데이터를 받아온다
			while (rs.next()) {
				//rs.getString("id")와 str을 비교하여 참이면 
				//뉴 인스턴스 Customer를 생성하여 id,password,name,address,phone을 cus에 담음
				if (rs.getString("id").equals(str)) {
					Customer cus = new Customer(rs.getString("id"), rs.getString("password"), 
							rs.getString("name"),rs.getString("address"), rs.getString("phone"));
					return cus;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//boolean타입의 dbselect메소드 생성. 입력받는값은 Customer cus
	public boolean dbselect(Customer cus) {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		String sql = "select id,password from customer";  // sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			
			//while문을 사용하여 rs.next()의 조건으로 데이터를 받아온다
			while (rs.next()) {
				//rs.getString("id")와 cus.getId()를 비교한 값과 rs.getString("password")와 cus.getPassword()를
				//비교한 값이 둘다 참일때 true값 도출
				if (rs.getString("id").equals(cus.getId()) && rs.getString("password").equals(cus.getPassword())) {
					return true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	//리턴값이 없는 dbfood() 메소드 생성
	public void dbfood() {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		String sql = "select * from food";  // sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			System.out.println(rs);  //rs를 출력되게 함

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Basket타입의 dbOrderBasket메소드 생성. 입력받는값은 int food
	public Basket dbOrderBasket(int food) {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		// sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		String sql = "select r.rest_name,f.food_name,f.price ,f.food_id from basket b,restaurant r,food f where b.bask_rest_id = r.rest_id and b.BASK_FOOD_ID = f.FOOD_ID";
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			ResultSet rs = pstmt.executeQuery();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			
			if(food == 0) { //if문으로 food가 0일때 아무것도 없음
			}
			System.out.println(rs);  //rs를 출력하게 함
			
			//while문을 사용하여 rs.next()의 조건으로 데이터를 받아온다
			while(rs.next()) {
			
			//if문으로 food가 rs.getInt("food_id")면 
			//뉴 인스턴스 Basket에 rs.getString("food_name"),rs.getString("rest_name"),rs.getInt("price")를 담고
			//bas에 저장함. 리턴값 bas;
			if (food == rs.getInt("food_id")) {
			Basket bas = new Basket(rs.getString("food_name"),rs.getString("rest_name"),rs.getInt("price"));
			return bas;
			}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//int타입의 dbbasket메소드 생성. 입력받는 값은 Basket bas
	public int dbbasket(Basket bas) {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		String sql = "insert into basket values(?,?,?)";  // sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			pstmt.setString(1, bas.getMyid());  //pstmt에서 setString으로 1, bas.getMyid()를 담음
			pstmt.setInt(2, bas.getMyrest());  //pstmt에서 setInt으로 2, bas.getMyrest()를 담음
			pstmt.setInt(3, bas.getMyfood());  //pstmt에서 setInt으로 3, bas.getMyfood()를 담음
			int rs = pstmt.executeUpdate();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			System.out.println(rs);  //rs를 출력되게 해줌
			return bas.getMyfood();  //리턴값은 bas의 getMyfood();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bas.getMyfood();
	}

	//반환값이없는 dbregistry메소드 생성. 입력받는값은 Customer cus
	public void dbregistry(Customer cus) {
		conn = dbconnect();  //디비커넥트 메소드를 conn에 담음. 디비연결하기위해서 선언
		String sql = "insert into customer values(?,?,?,?,?)";  // sql쿼리를 문자타입의 sql에 담음. 쿼리를 실행하기위해서 선언
		
		//트라이 캐치로 오류를 캐치가 잡아줌
		try {
			pstmt = conn.prepareStatement(sql);  //conn의 sql쿼리문을 pstmt에 담음
			pstmt.setString(1, cus.getId());  //pstmt에서 setString으로 1, cus.getId()를 담음
			pstmt.setString(2, cus.getAdress());  //pstmt에서 setString으로 2, cus.getAdress()를 담음
			pstmt.setString(3, cus.getName());  //pstmt에서 setString으로 3, cus.getName()를 담음
			pstmt.setString(4, cus.getPhone());  //pstmt에서 setString으로 4, cus.getPhone()를 담음
			pstmt.setString(5, cus.getPassword());  //pstmt에서 setString으로 5, cus.getPassword()를 담음
			int rs = pstmt.executeUpdate();  //pstmt의 sql을 실행하게해주는 메소드를 rs에 담음
			System.out.println(rs);  //rs를 출력되게 해줌

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}