package AntShares.Core;

import java.io.IOException;
import java.util.Arrays;

import AntShares.UInt160;
import AntShares.IO.*;
import AntShares.IO.Json.*;

public class ClaimTransaction extends Transaction
{
	public TransactionInput[] claims;
	
	public ClaimTransaction()
	{
		super(TransactionType.ClaimTransaction);
	}
	
	@Override
	protected void deserializeExclusiveData(BinaryReader reader) throws IOException
	{
        try
        {
			claims = reader.readSerializableArray(TransactionInput.class);
		}
        catch (InstantiationException | IllegalAccessException ex)
        {
        	throw new IOException(ex);
		}
        if (claims.length == 0) throw new IOException();
        if (Arrays.stream(claims).distinct().count() != claims.length)
            throw new IOException();
	}
	
	@Override
	public UInt160[] getScriptHashesForVerifying()
	{
		//TODO
		return super.getScriptHashesForVerifying();
	}
	
	@Override
	public JObject json()
	{
        JObject json = super.json();
        json.set("claims", new JArray(Arrays.stream(claims).map(p -> p.json()).toArray(JObject[]::new)));
        return json;
	}
	
	@Override
	protected void serializeExclusiveData(BinaryWriter writer) throws IOException
	{
		writer.writeSerializableArray(claims);
	}
	
	@Override
	public boolean verify()
	{
		//TODO
		return super.verify();
	}
}
