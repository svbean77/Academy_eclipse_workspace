// 03
package com.shinhan.day07;

public class ProductTest {
	public static void main(String[] args) {
		ProductVO[] productList = { new ProductVO("마이쭈", 25000, "Samsong"), new ProductVO("꿈틀이", 32000, "Samsong"),
				new ProductVO("짱구", 17050, "Samsong"), new ProductVO("새우깡", 24500, "Samsong"),
				new ProductVO("고소미", 75000, "Daehoo") };
		productList = selectProduct(productList, 25000);
//		productList = new ProductTest().selectProduct(productList, 25000); // 함수가 static이 아니라면 이렇게 호출해야 함
		for (int i = 0; i < productList.length; i++) {
			System.out.println(productList[i].toString());
		}
	}

	// Object를 상속받아 ProductVO를 만든 것 -> 이 함수로 들어올 때 자동 형변환 (부모타입 참조변수 = 자식객체)
	private static ProductVO[] selectProduct(Object[] productList, int i) {
//		내 풀이 (배열을 두 번 쓰는게 마음에 안들어..)
//		ProductVO[] tempList = new ProductVO[productList.length];
//		int cnt = 0;
//
//		for (int idx = 0; idx < productList.length; idx++) {
//			ProductVO tmp = (ProductVO) productList[idx];
//			tmp.toString();
//
//			if (tmp.getPrice() >= i) {
//				tempList[cnt] = tmp;
//				cnt++;
//			}
//		}
//
//		ProductVO[] newList = new ProductVO[cnt];
//
//		for (int idx = 0; idx < cnt; idx++) {
//			newList[idx] = tempList[idx];
//		}
//
//		return newList;

//		교수님 풀이 -> 이 경우에는 Collection의 List를 쓰는 것이 더 좋다! (지금은 안 배웠으니까 일단 배열로)
//		: 배열은 개수를 알 수 없다면 생성 불가이기 때문에 반복문을 2번 돌아야 함 (조건 찾기 + 배열 생성 후 대입)
		int index = 0;
//		조건에 맞는 객체 개수만 뽑아내는 for
		for (Object obj : productList) {
//			Object -> ProductVO로 강제 형변환 필요: (자식타입 참조변수 = (자식타입) 부모객체)
//			무조건 되는 것은 아님! 전제조건: 부모 객체가 자식타입에서 자동 형변환 된 경우만 가능! (실행시 에러)
//			ProductVO product = (ProductVO) obj; // 이 방법도 가능하지만 obj가 ProductVO가 아니면 에러잖아
			if (!(obj instanceof ProductVO product))
//				instance이면 해야 할 코드가 많음 -> instance가 아닐 때 먼저 적자! (내용이 너무 많아지잖아)
				continue;
			if (product.getPrice() >= i)
				index++;

		}

//		조건에 맞는 객체만큼 새로운 배열을 생성
		ProductVO[] pList = new ProductVO[index];
		index = 0;
		for (Object obj : productList) {
			if (!(obj instanceof ProductVO product))
				continue;
			if (product.getPrice() >= i) {
				pList[index] = product;
				index++;
			}
		}
		return pList;
	}
}
