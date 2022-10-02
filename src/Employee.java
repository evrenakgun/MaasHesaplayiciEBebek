
public class Employee {
	
	String name; //Çalışanın adı ve soyadı
	double salary; //Çalışanın maaşı
	double workHours; //Haftalık çalışma saati
	int hireYear; //İşe başlangıç yılı
	
	//Constructor metot
	public Employee (String name, double salary, double workHours, int hireYear) {
		this.name = name;
		this.salary = salary;
		this.workHours = workHours;
		this.hireYear = hireYear;
	}
	
	//Projeyi çalıştıran metot
	public void run() {
		printInfo();
		System.out.println("------------------------------------");
	}

	//Maaşa uygulanan vergi metotu
	public double tax() {
		double taxRate = 0.03;
		
		if (salary > 1000) {
			return salary * taxRate;
		}
		else {
			return 0;
		}	
	}
	
	//Mesai ücreti hesaplanan metot
	public double bonus() {
		double bonusSalary = 0; //Bu değişken mesai ücretini tanımlamaktadır.
		
		if (workHours > 40) {
			bonusSalary = 30.0 * (workHours - 40);
			return bonusSalary;
		}
		else {
			return 0;
		}
	}
	
	//Başlangıç yılına göre zam oranlarını hesaplayan metot
	public double raiseSalary() {
		double raiseRate1 = 0.05; //10 yıldan az bir süredir çalışıyorsa (10 dahil değil)
		double raiseRate2 = 0.10; //10 yıldan fazla ama 20 yıldan az bir süredir çalışıyorsa (10 dahil, 20 dahil değil)
		double raiseRate3 = 0.15; //20 yıldan fazla süredir çalışıyorsa (20 dahil)
		double newSalary = salary + bonus() - tax(); //Çalışanın mesai ücreti ve vergisi dahil edilmiş maaşı
		
		if ((2021 - hireYear) < 10) {
			return newSalary * raiseRate1;
		}
		else if ((2021 - hireYear) >= 10 && (2021 - hireYear) < 20) {
			return newSalary * raiseRate2;
		}
		else if ((2021 - hireYear) >= 20) {
			return newSalary * raiseRate3;
		}
		else {
			return 0;
		}
	}
	
	//Çalışanın maaşının en son hali
	public double netSalary() {
		return salary + bonus() + raiseSalary() - tax();
	}
	
	//Çalışan bilgileri
	public void printInfo() {
		System.out.println("Ad ve Soyad\t: " + name);
		System.out.println("Maaş\t\t: " + salary + " TL");
		System.out.println("Çalışma Saati\t: " + workHours);
		System.out.println("Başlangıç Yılı\t: " + hireYear);
		System.out.println("Vergi Miktarı\t: " + tax() + " TL");
		System.out.println("Bonus Miktarı\t: " + bonus() + " TL"); //Mesai ücreti
		System.out.println("Kıdem Bonusu\t: " + raiseSalary() + " TL"); //Çalışanın çalıştığı yıla göre maaş artışı
		System.out.println("Net Maaş\t: " + netSalary() + " TL"); //Bütün artı ve eksilerden sonraki maaş
	}
}
