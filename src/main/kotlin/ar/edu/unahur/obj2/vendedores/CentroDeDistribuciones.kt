package ar.edu.unahur.obj2.vendedores

class CentroDeDistribuciones(val provincia: Provincia, vendedores: List<Vendedor> )
{
    //NO DEVUELVE NADA
    fun agregarVendedor(vendedor: Vendedor)
    {
        if(vendores.contains(vendedor))
        {

        }
        else
        {
            vendedores.add(vendedor)
        }
    }
}

