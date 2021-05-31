package meuu;

public class meuuEx {

	public static void main(String[] args) {
		int [][] scores = {
				{ 90, 70, 80, 75, 80 },
					{ 77, 90, 65, 80, 90 },
					{ 80, 75, 95, 80, 75 },
					{ 75, 80, 90, 85, 90 }
				};
		
		int sum = 0;
		int a = 0;
		
		for ( int i = 0 ; i <scores.length; i++){
			for (int j = 0; j < scores[i].length; j++){
				sum += scores[i][j];
				a++;
			}
		}

		System.out.println(sum);
	}
}



	