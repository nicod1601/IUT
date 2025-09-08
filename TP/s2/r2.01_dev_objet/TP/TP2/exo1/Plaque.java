/** Classe Vehicule
 * @author Philippe Le Pivert
*/
public class Plaque
{
	private int[] tabNum;
	private char[] tabLettreD;
	private char[] tabLettreF;

	public Plaque ()
	{
		this.tabNum = new int[]{0,0,0};

		this.tabLettreD = new char[]{'A','A'};
		this.tabLettreF = new char[]{'A','A'};
	}

	public void ajoutNum()
	{
		this.tabNum[2]++;

		if (this.tabNum[2] == 10)
		{
			this.tabNum[2] = 0;
			this.tabNum[1]++;
			if (this.tabNum[1] == 10)
			{
				this.tabNum[1] = 0;
				this.tabNum[0]++;
			}
		}
	}

	public void Lettre()
	{
		if(this.tabNum[0] == 9 && this.tabNum[1] == 9 && this.tabNum[2] == 9)
		{
			this.tabNum[0] = 0;
			this.tabNum[1] = 0;
			this.tabNum[2] = 0;


			this.tabLettreF[1]++;

			if(this.tabLettreF[1] == 'Z')
			{
				this.tabLettreF[1] = 'A';
				this.tabLettreD[1] = 'B';
			}
		}

		if(this.tabLettreD[1] == 'Z')
		{
			this.tabLettreD[1] = 'A';
			this.tabLettreD[0]++;
		}
	}

	public String toString()
	{
		String res = "";

		for (int cpt = 0; cpt < this.tabLettreD.length; cpt++)
		{
			res += this.tabLettreD[cpt];
		}

		res += " - ";

		for (int cpt = 0; cpt < this.tabNum.length; cpt++)
		{
			res += "" + this.tabNum[cpt];
		}

		res += " - ";

		for (int cpt = 0; cpt < this.tabLettreF.length; cpt++)
		{
			res += this.tabLettreF[cpt];
		}

		return res;
	}


	public static void main(String[] a)
	{
	Plaque p = new Plaque();
	System.out.println(p);

	for(int cpt = 0; cpt < 100000; cpt++)
	{
		p.ajoutNum();
		p.Lettre();

		/*try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}*/
		System.out.println(p);
	}

	}
}


