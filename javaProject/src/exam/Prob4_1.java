// 교수님 풀이
package exam;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4_1 {

	public static void main(String[] args) {
		Product2[] prodList = { new Product2("NT450R5E-K24S", 500000, "삼성전자"),
				new Product2("15UD340-LX2CK", 400000, "LG전자"), new Product2("G2-K3T32AV", 600000, "HP") };
		HashSet<Product2> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
	}

	private static HashSet<Product2> makeHashSet(Product2[] prodList, int price) {
		// 구현하시오...return값 수정하기
//		HashSet을 제네릭을 사용해도 된다고 문제 수정
		HashSet<Product2> plist = new HashSet<>();

		System.out.println("*특정 금액 이상의 상품 결과입니다. ********************");
		for (Product2 pro : prodList) {
			if (pro.getPrice() >= price) {
				plist.add(pro);
				System.out.println(pro);
			}
		}

		return plist;
	}

	private static void makeFile(HashSet<Product2> resultList) {
		// 구현하시오.

		try (FileOutputStream fos = new FileOutputStream("src/data2.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (Product2 pro : resultList) {
				oos.writeObject(pro);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile() {
		// 구현하시오.
		System.out.println("*readFile 결과입니다. ********************");
		try (FileInputStream fis = new FileInputStream("src/data2.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			while (true) {
				Object obj = ois.readObject();
				if (obj instanceof Product2 pro) {
					System.out.println(pro);
				}
			}

		} catch (EOFException e) {

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}

class Product2 implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product2(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}

}