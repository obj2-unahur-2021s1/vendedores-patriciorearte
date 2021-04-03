package ar.edu.unahur.obj2.vendedores
import kotlin.Boolean as Boolean
//mutableListOf<Certificacion>
class CentroDeDistribuciones(val provincia: Provincia)
{
    val vendedores = mutableListOf<Vendedor>()
    //NO DEVUELVE NADA
    fun agregarVendedor(vendedor: Vendedor)
    {
        if(vendedores.contains(vendedor))
        {
            this.error("Ya lo tiene")
        }
        else {
            vendedores.add(vendedor)
        }
    }
    //El vendedor estrella, que es el que tiene mayor puntaje total por certificaciones.
    //Devuelve un vendedor
    fun esVendedorEstrella(): Vendedor
    {
        return vendedores.max{c-> c.puntajeCertificaciones}
    }
    //Devuelve un Booleano
    fun puedeCubrir(ciudad: Ciudad): Boolean {
        return vendedores.any{c->c.puedeTrabajarEn(ciudad)}

    }
    //La colección de vendedores genéricos registrados. Un vendedor se considera genérico si tiene al menos una certificación que no es de productos.
    //Devuelve una lista de vendedores
    fun vendedoresGenericosRegistrados(): List<Vendedor>
    {
        return  vendedores.filter{c->c.esVendedorGenerico()}

    }
    //Si es robusto, la condición es que al menos 3 de sus vendedores registrados sea firme.
    fun esRobusto(): Boolean
    {
        return vendedores.count{c->c.esFirme()}>=3

    }
}

