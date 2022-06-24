package ar.edu.utn.link.tpintegrador.security.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import ar.edu.utn.link.tpintegrador.model.Producto;
import ar.edu.utn.link.tpintegrador.model.Promocion1;

@Entity
public class Usuario1 {// esta es la que va a la base de datos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String nombre;
	@NotNull
	@Column(unique = true)
	private String nombreUsuario;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@OneToMany
	private Collection<Producto> productosComprados;// esto re necesario

	@OneToMany
	private Collection<Producto> productosAVender;

	@OneToOne // justo este momento estoy agregando estooo

	private Promocion1 promocion;

	private int profile;

	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), // La tabla intermedia tiene
																						// usuario_id y rol_id
			inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>(); // muchos a muchos
	
	
	

	public Usuario1(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password, Collection<Producto> productosAVender, int profile) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.productosAVender = productosAVender;
		this.profile = profile;
	}

	public Usuario1(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password, Promocion1 promocion, int profile) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.promocion = promocion;
		this.profile = profile;
	}

	public int getProfile() {
		return profile;
	}

	public void setProfile(int profile) {
		this.profile = profile;
	}

	public Collection<Producto> getProductosComprados() {
		return productosComprados;
	}

	public void setProductosComprados(Collection<Producto> productosComprados) {
		this.productosComprados = productosComprados;
	}

	public Collection<Producto> getProductosAVender() {
		return productosAVender;
	}

	public void setProductosAVender(Collection<Producto> productosAVender) {
		this.productosAVender = productosAVender;
	}

	public Promocion1 getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion1 promocion) {
		this.promocion = promocion;
	}

	public Usuario1() {
	}

	// public void agregarACarrito(Producto p) {
//		carrito.getProductos().add(p);//carrito me da su lista de productos y agrego p
//	}

	public Usuario1(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password, int profile) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}

	public Usuario1(int id, @NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password, @NotNull Set<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public void comprar(Producto producto) {
		this.productosComprados.add(producto);

	}

	public Collection<Producto> getProductos() {
		return productosComprados;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productosComprados = productos;
	}

	public Usuario1(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email,
			@NotNull String password, @NotNull Set<Rol> roles, Collection<Producto> productos) {
		super();
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.productosComprados = productos;
	}

}
