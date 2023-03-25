// makeHashSet 메소드를 stream 이용한 방법으로 바꿔보았습니다.
package exam;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"), new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
	}

	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		// 구현하시오...return값 수정하기
//		HashSet을 제네릭을 사용해도 된다고 문제 수정
		HashSet<Product> set = new HashSet<>();

//		방법 1
		for (Product prod : prodList) {
			if (prod.getPrice() >= price) {
				set.add(prod);
			}
		}

//		방법 2
		Set<Product> tmp = Arrays.stream(prodList).filter(p -> p.getPrice() >= price).collect(Collectors.toSet());
		for (Product p : tmp) {
			set.add(p);
		}

		return set;
	}

	private static void makeFile(HashSet resultList) {
		// 구현하시오.
		System.out.println("*특정 금액 이상의 상품 결과입니다. ********************");
		try {
			FileOutputStream fw = new FileOutputStream("src/data.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fw);

			for (Object prod : resultList) {
				Product p = (Product) prod;
				oos.writeObject(p);
				System.out.println(p);
			}

			oos.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void readFile() {
		// 구현하시오.
		System.out.println("*readFile 결과입니다. ********************");
		try {
			FileInputStream fi = new FileInputStream("src/data.txt");
			ObjectInputStream ois = new ObjectInputStream(fi);

			Product p;
			try {
				while ((p = (Product) ois.readObject()) != null) {
					System.out.println(p);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (EOFException e) {

			}

			ois.close();
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class Product implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
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