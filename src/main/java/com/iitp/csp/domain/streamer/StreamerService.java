package com.iitp.csp.domain.streamer;

import com.iitp.csp.domain.member.entity.Member;
import com.iitp.csp.domain.member.entity.MemberRepository;
import com.iitp.csp.domain.streamer.entity.Streamer;
import com.iitp.csp.domain.streamer.entity.StreamerRepository;
import com.iitp.csp.domain.streamer.entity.dto.StreamerPutReqDto;
import com.iitp.csp.domain.streamer.entity.dto.StreamerReqDto;
import com.iitp.csp.domain.streamer.entity.dto.StreamerResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StreamerService {
    @Autowired
    private StreamerRepository streamerRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public Long postStreamer(StreamerReqDto dto) {
        Member member = memberRepository.findById(dto.getMemberId()).orElseThrow(()-> new RuntimeException());
        Streamer streamer = dto.toEntity();
        streamer.setMember(member);
        return streamerRepository.save(streamer).getStreamerId();
    }

    @Transactional(readOnly = true)
    public StreamerResDto getStreamer(Long id) {
        Streamer streamer = streamerRepository.findById(id).orElseThrow(() -> new RuntimeException("해당게시물없음"));
        return new StreamerResDto(streamer);
    }

    @Transactional
    public Long putStreamer(Long id, StreamerPutReqDto dto) {
        Streamer streamer = streamerRepository.findById(id).orElseThrow(()->new RuntimeException("해당게시물없음"));

        streamer.setStreamer(dto.getTitle(),dto.getContent());
        Streamer result = streamerRepository.save(streamer);
        return result.getStreamerId();
    }

    public void deleteStreamer(Long id) { streamerRepository.deleteById(id); }

    @Transactional(readOnly = true)
    public  Page<Streamer> getStreamerPage(Pageable page) { return streamerRepository.findAll(page); }

}
