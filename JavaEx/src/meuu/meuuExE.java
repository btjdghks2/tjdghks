package meuu;

public class meuuExE {

private static Car Car;

public static void main(String[] args) {
	Car = new Car();

	출처: https://altongmon.tistory.com/119 [IOS를 Java]
	int [][] scores = {
			{ 90, 70, 80, 75, 80 },
				{ 77, 90, 65, 80, 90 },
				{ 80, 75, 95, 80, 75 },
				{ 75, 80, 90, 85, 90 }
			};

int sum=0;
int count=0;


for(int i=0; i for(int k=0;k sum += array[i][k];
count++;
}
}
System.out.println("배열 요소의 총 합 = "+sum);

}}

