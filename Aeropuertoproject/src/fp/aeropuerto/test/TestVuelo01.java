package fp.aeropuerto.test;


import java.util.LinkedList;
import java.util.List;

import fp.aeropuerto.Vuelo;

public class TestVuelo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vuelo v1 = new Vuelo("Madrid;107;150;150;RYR-80;01/06/2020-15:28;78;15;21.4");
		Vuelo v2 = new Vuelo("Madrid;107;150;150;RYR-290;01/06/2020-12:22;78;15;32.1");
		Vuelo v3 = new Vuelo("Valencia;50.6;180;150;VLG-400;01/06/2020-14:03;45;18;15.18");
		Vuelo v4 = new Vuelo("Valencia;55.6;180;180;VLG-300;02/06/2020-13:44;45;18;27.8");
		Vuelo v5 = new Vuelo("Barcelona;100.79;300;250;IBE-840;02/06/2020-21:20;65;30;50.4");
		Vuelo v6 = new Vuelo("Barcelona;90;300;250;IBE-104;02/06/2020-22:08;65;30;36");
		Vuelo v7 = new Vuelo("Oviedo;90;260;222;VLG-780;03/06/2020-13:45;80;26;27");


	List<Vuelo> misVuelos=new LinkedList<Vuelo>();
	misVuelos.add(v1);
	misVuelos.add(v2);
	misVuelos.add(v3);
	misVuelos.add(v4);
	misVuelos.add(v5);

	System.out.println("Númerode vuelos: "+ misVuelos.size());
	System.out.println("\nFecha del tercer vuelo: "+misVuelos.get(2).getFecha());
	System.out.println("Primer vuelo: "+misVuelos.get(0));
	System.out.println("Tercer vuelo: "+misVuelos.get(2));
	//System.out.println("Fecha del tercer vuelo: "+misVuelos.get(2).getFecha(null));
	System.out.println();
	System.out.println("Vuelos de la posición 1 a 3: "+misVuelos.subList(1, 4));

	misVuelos.add(1, v6);
	misVuelos.add(0, v7);

	System.out.println("Son iguales los vuelos tercero y quinto: "+misVuelos.get(2).equals(misVuelos.get(4)));
	System.out.println("\n¿Es menor el tercer vuelo que el quinto?"+misVuelos.get(3).compareTo(misVuelos.get(5)));

		}
	
}
