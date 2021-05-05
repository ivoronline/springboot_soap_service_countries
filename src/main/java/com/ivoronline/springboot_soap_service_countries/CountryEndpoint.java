package com.ivoronline.springboot_soap_service_countries;


import com.ivoronline.soap.Country;
import com.ivoronline.soap.GetCountryRequest;
import com.ivoronline.soap.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

  private static final String NAMESPACE_URI = "http://ivoronline.com/soap";

  @Autowired private CountryRepository countryRepository;

  //=====================================================================================
  // GET COUNTRY REQUEST
  //=====================================================================================
  @ResponsePayload
  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest) {

    //GET COUNTRY NAME
    String name = getCountryRequest.getName();

    //GET COUNTRY
    Country country = countryRepository.findCountry(name);

    //CREATE GetCountryResponse
    GetCountryResponse getCountryResponse = new GetCountryResponse();
		                   getCountryResponse.setCountry(country);

    //RETURN GetPersonResponse
		return getCountryResponse;

	}

}

