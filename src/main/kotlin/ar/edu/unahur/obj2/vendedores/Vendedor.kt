package ar.edu.unahur.obj2.vendedores

import kotlin.Boolean as Boolean

class Certificacion(val esDeProducto: Boolean, val puntaje: Int)

abstract class Vendedor {
  // Acá es obligatorio poner el tipo de la lista, porque como está vacía no lo puede inferir.
  // Además, a una MutableList se le pueden agregar elementos
  val certificaciones = mutableListOf<Certificacion>()

  //Metodo abstract
  abstract fun esVendedorInfluyente(): Boolean



  // Definimos el método abstracto.
  // Como no vamos a implementarlo acá, es necesario explicitar qué devuelve.
  abstract fun puedeTrabajarEn(ciudad: Ciudad): Boolean

  // En las funciones declaradas con = no es necesario explicitar el tipo
  fun esVersatil() =
    certificaciones.size >= 3
      && this.certificacionesDeProducto() >= 1
      && this.otrasCertificaciones() >= 1
  //Devuelve un Booleano
  // Si el tipo no está declarado y la función no devuelve nada, se asume Unit (es decir, vacío)
  fun agregarCertificacion(certificacion: Certificacion) {
    certificaciones.add(certificacion)
  }

  fun esFirme() = this.puntajeCertificaciones() >= 30
  //Devuelve un Booleano
  fun certificacionesDeProducto() = certificaciones.count { it.esDeProducto }
  //Devuelve un numero
  fun otrasCertificaciones() = certificaciones.count { !it.esDeProducto }
  //Devuelve un numero
  fun puntajeCertificaciones() = certificaciones.sumBy { c -> c.puntaje }
  //Devuelve un numero
}

// En los parámetros, es obligatorio poner el tipo
class VendedorFijo(val ciudadOrigen: Ciudad) : Vendedor()
{
  //Devuelve un booleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudad == ciudadOrigen
  }
  //Devuelve un booleano
  override fun esVendedorInfluyente(): Boolean {
    return False
  }
}

// A este tipo de List no se le pueden agregar elementos una vez definida
class Viajante(val provinciasHabilitadas: List<Provincia>) : Vendedor()
{
  //Devuelve un booleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return provinciasHabilitadas.contains(ciudad.provincia)
  }
  //Devuelve un booleano
  override fun esVendedorInfluyente(): Boolean {
    return provinciasHabilitadas.sumBy { c ->c.poblacion }>=10000000
  }
}


class ComercioCorresponsal(val ciudades: List<Ciudad>) : Vendedor()
{
  //Devuelve un booleano
  override fun puedeTrabajarEn(ciudad: Ciudad): Boolean {
    return ciudades.contains(ciudad)
  }
  //Devuelve un booleano
  override fun esVendedorInfluyente(): Boolean
  {
    //Consultar
    return this.ciudades.size>=5 || this.ciudades.map{c->c.provincia}.size >=3
  }


}
