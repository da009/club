import java.util.ArrayList;

/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    // ArrayList para los miembros.
    private ArrayList<Membership> socios;
    // ArrayList para los miembros dados de baja.
    private ArrayList<Membership> bajas;
    
    /**
     * Constructor for objects of class Club
     */
    public Club()
    {
        socios = new ArrayList<Membership>();
        bajas = new ArrayList<Membership>();
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        socios.add(member);
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return socios.size();
    }
    
    /** 
     * Calcula el numero de socios que se dieron de alta en un mes determinado. 
     * El año no nos importa. En caso de que el parametro contenga un valor 
     * no valido se muestra por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @return El numero de socios que se dieron de alta dicho mes
     */
    public int joinedMonth(int mes)
    {
        int cont = 0;
        if (mes >= 1 && mes <= 12)
        {
            for (Membership socio : socios)
            {
                if (mes == socio.getMonth())
                {
                    cont ++;
                }
                else if (cont == 0)
                {
                    System.out.println("No se han registrado socios ese mes.");
                }
            }
        }
        return cont;
    }
    
    /** 
     * Todos los socios que se han dado de alta un determinado mes de un determinado año se
     * dan de baja. En caso de que el parametro month contenga un valor no valido se muestra 
     * por pantalla el error.
     * @param month El mes en el que estamos interesados
     * @param year El año en el que estamos interesados
     * @return Una coleccion con los socios que se han dado de baja del club
     */
    public void purge(int month, int year)
    {
        int index = 0;
        if (month >= 1 && month <= 12)
        {
            while (socios.size() > index)
            {
                if (month == socios.get(index).getMonth() && year == socios.get(index).getYear())
                {
                    bajas.add(socios.get(index));
                    socios.remove(socios.get(index));
                }
                index++;
            }
        }
        else
        {
            System.out.println("El valor introducido para el mes no es valido");
        }
    }
}
