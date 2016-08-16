package AntShares.IO.Caching;

public interface ITrackable<TKey>
{
    TKey getKey();
    TrackState getTrackState();
    void setTrackState(TrackState state);
}