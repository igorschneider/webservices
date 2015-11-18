package edu.luc.lakezon.service.representation;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import edu.luc.lakezon.business.Link;

public abstract class BaseRepresentation {
	
	@XmlElement(name="link", namespace="")
	protected List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(Link...links) {
		this.links = Arrays.asList(links);
	}

}
