package com.hexaware.entity;


/**
 * Represents a geographical point with latitude and longitude coordinates.
 */
public class GeoPoint {
  private double latitude;
  private double longitude;

  /**
   * Constructs a GeoPoint with the specified latitude and longitude.
   *
   * @param latitude  The latitude coordinate of the geographical point.
   * @param longitude The longitude coordinate of the geographical point.
   */
  public GeoPoint(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Gets the latitude coordinate of the geographical point.
   *
   * @return The latitude coordinate.
   */
  public double getLatitude() {
    return latitude;
  }

  /**
   * Gets the longitude coordinate of the geographical point.
   *
   * @return The longitude coordinate.
   */
  public double getLongitude() {
    return longitude;
  }
  
  @Override
  public String toString() {
    return "GeoPoint [latitude=" + latitude + ", longitude=" + longitude + "]";
  }
}

