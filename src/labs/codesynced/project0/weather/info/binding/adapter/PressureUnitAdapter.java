/**
 * 
 */
package labs.codesynced.project0.weather.info.binding.adapter;

import labs.codesynced.project0.weather.info.data.unit.PressureUnit;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Units of barometric pressure adapter, in for pounds per square inch or mb for millibars.
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class PressureUnitAdapter extends XmlAdapter<String, PressureUnit>
{

	private static final String MB = "mb";
	private static final String IN = "in";
	
	//private Logger logger = LoggerFactory.getLogger(PressureUnitAdapter.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PressureUnit unmarshal(String v) throws Exception {
		if (IN.equalsIgnoreCase(v)) return PressureUnit.IN;
		if (MB.equalsIgnoreCase(v)) return PressureUnit.MB;
		//logger.warn("Unknown pressure unit \"{}\"", v);
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String marshal(PressureUnit v) throws Exception {
		switch (v) {
			case IN: return IN;
			case MB: return MB;
			default: return "";
		}
	}

}
