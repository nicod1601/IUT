import iut.algo.Decomposeur;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


public class Clientele
{

	private List<Client> lstClients;

	public Clientele()
	{
		this.lstClients = new ArrayList<Client>();
		this.initTabClients();
	}

	public void initTabClients()
	{
		Scanner     scFic;
		Decomposeur dec;

		String      sPremium;
		boolean     bPremium;

		try
		{
			scFic = new Scanner ( new FileInputStream ( "clients.data" ), "UTF8" );

			while ( scFic.hasNextLine() )
			{

				dec = new Decomposeur ( scFic.nextLine() );

				sPremium = dec.getString(2);
				bPremium = sPremium.equals ( "true" );

				//                                    nom                prenom         premium     anneeAdh
				this.lstClients.add ( new Client ( dec.getString(1), dec.getString(0), bPremium, dec.getInt(3) ) );
			}

			scFic.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majPremiumClient ( int ligne, boolean val )
	{
		return this.lstClients.get(ligne).setPremium ( val );
	}


	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("clients.data"), "UTF8" ));

			for (Client clt:this.lstClients )
			{
				pw.println ( clt.getPrenom   () + "\t" +
				             clt.getNom      () + "\t" +
				             clt.getPremium  () + "\t" +
				             clt.getAnneeAdh ()           );

			}
			pw.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public List<Client> getClients()
	{
		return new ArrayList<Client>( this.lstClients );
	}


	public String toString()
	{
		String sRet = "";

		for ( Client clt: this.lstClients )
			sRet += clt.toString() + "\n";

		return sRet;
	}
}


