package AntShares.Cryptography;

import java.security.*;

public class Digest
{
	public static byte[] hash256(byte[] value)
	{
		return sha256(sha256(value));
	}
	
	public static byte[] sha256(byte[] value)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return md.digest(value);
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}
	}
	
	public static byte[] sha256(byte[] value, int offset, int length)
	{
		if (offset != 0 || length != value.length)
		{
			byte[] array = new byte[length];
			System.arraycopy(value, offset, array, 0, length);
			value = array;
		}
		return sha256(value);
	}
}
