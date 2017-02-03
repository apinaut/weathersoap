package com.apiomat.nativemodule.soapweathertransient.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java-Klasse für anonymous complex type.
 *
 * <p>
 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Table" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "", propOrder = {
	"table"
} )
@XmlRootElement( name = "NewDataSet" )
public class NewDataSet
{

	@XmlElement( name = "Table" )
	protected List<NewDataSet.Table> table;

	/**
	 * Gets the value of the table property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the table property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getTable( ).add( newItem );
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link NewDataSet.Table }
	 *
	 *
	 */
	public List<NewDataSet.Table> getTable( )
	{
		if ( this.table == null )
		{
			this.table = new ArrayList<NewDataSet.Table>( );
		}
		return this.table;
	}

	/**
	 * <p>
	 * Java-Klasse für anonymous complex type.
	 *
	 * <p>
	 * Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
	 *
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 *
	 *
	 */
	@XmlAccessorType( XmlAccessType.FIELD )
	@XmlType( name = "", propOrder = {
		"country",
		"city"
	} )
	public static class Table
	{

		@XmlElement( name = "Country", required = true )
		protected String country;
		@XmlElement( name = "City", required = true )
		protected String city;

		/**
		 * Ruft den Wert der country-Eigenschaft ab.
		 *
		 * @return
		 * 		possible object is
		 *         {@link String }
		 *
		 */
		public String getCountry( )
		{
			return this.country;
		}

		/**
		 * Legt den Wert der country-Eigenschaft fest.
		 *
		 * @param value
		 *        allowed object is
		 *        {@link String }
		 *
		 */
		public void setCountry( String value )
		{
			this.country = value;
		}

		/**
		 * Ruft den Wert der city-Eigenschaft ab.
		 *
		 * @return
		 * 		possible object is
		 *         {@link String }
		 *
		 */
		public String getCity( )
		{
			return this.city;
		}

		/**
		 * Legt den Wert der city-Eigenschaft fest.
		 *
		 * @param value
		 *        allowed object is
		 *        {@link String }
		 *
		 */
		public void setCity( String value )
		{
			this.city = value;
		}

	}

}
